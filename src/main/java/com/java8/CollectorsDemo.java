package com.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsDemo {

	static List<Student> studentList = new ArrayList<Student>();

	public static void main(String[] args) {

		// Example : Collecting top 3 performing students into List
		List<Student> top3Students = studentList.stream()
				.sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3)
				.collect(Collectors.toList());
		System.out.println(top3Students);

		// Example : Collecting subjects offered into Set.
		Set<String> subjects = studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
		System.out.println(subjects);

		// Example : Collecting name and percentage of each student into a Map
		Map<String, Double> namePercentageMap = studentList.stream()
				.collect(Collectors.toMap(Student::getName, Student::getPercentage));
		System.out.println(namePercentageMap);

		// Example : Collecting first 3 students into LinkedList
		LinkedList<Student> studentLinkedList = studentList.stream().limit(3)
				.collect(Collectors.toCollection(LinkedList::new));
		System.out.println(studentLinkedList);

		// Example : Collecting the names of all students joined as a string
		String namesJoined = studentList.stream().map(Student::getName).collect(Collectors.joining(", "));
		System.out.println(namesJoined);

		// Example : Counting number of students.
		Long studentCount = studentList.stream().collect(Collectors.counting());
		System.out.println(studentCount);

		// Example : Collecting highest percentage.
		Optional<Double> highPercentage = studentList.stream().map(Student::getPercentage)
				.collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println(highPercentage);

		// Example : Collecting lowest percentage.
		Optional<Double> lowPercentage = studentList.stream().map(Student::getPercentage)
				.collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(lowPercentage);

		// Example : Collecting sum of percentages
		Double sumOfPercentages = studentList.stream().collect(Collectors.summingDouble(Student::getPercentage));
		System.out.println(sumOfPercentages);

		// Example : Collecting average percentage
		Double averagePercentage = studentList.stream().collect(Collectors.averagingDouble(Student::getPercentage));
		System.out.println(averagePercentage);

		// Example : Extracting highest, lowest and average of percentage of students
		DoubleSummaryStatistics studentStats = studentList.stream()
				.collect(Collectors.summarizingDouble(Student::getPercentage));
		System.out.println("Highest Percentage : " + studentStats.getMax());
		System.out.println("Lowest Percentage : " + studentStats.getMin());
		System.out.println("Average Percentage : " + studentStats.getAverage());

		// Example : Grouping the students by subject
		Map<String, List<Student>> studentsGroupedBySubject = studentList.stream()
				.collect(Collectors.groupingBy(Student::getSubject));
		System.out.println(studentsGroupedBySubject);
		
		// Example : Grouping the students by subject
				Map<Object, Long> subjectWiseStudentCount = studentList.stream()
						.collect(Collectors.groupingBy(student->student.getSubject(),Collectors.counting()));
				System.out.println(subjectWiseStudentCount);
				

		// Example : Partitioning the students who got above 80.0% from who don’t.
		Map<Boolean, List<Student>> studentspartionedByPercentage = studentList.stream()
				.collect(Collectors.partitioningBy(student -> student.getPercentage() > 80.0));
		System.out.println(studentspartionedByPercentage);

		// Example : Collecting first three students into List and making it
		// unmodifiable
		List<Student> first3Students = studentList.stream().limit(3)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println(first3Students);

	}

	static {
		studentList.add(new Student("Paul", 11, "Economics", 78.9));
		studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
		studentList.add(new Student("Harish", 13, "History", 83.7));
		studentList.add(new Student("Xiano", 14, "Literature", 71.5));
		studentList.add(new Student("Soumya", 15, "Economics", 77.5));
		studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
		studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
		studentList.add(new Student("Mitshu", 18, "History", 73.5));
		studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
		studentList.add(new Student("Harry", 20, "History", 71.9));
	}
}

class Student {
	String name;

	int id;

	String subject;

	double percentage;

	public Student(String name, int id, String subject, double percentage) {
		this.name = name;
		this.id = id;
		this.subject = subject;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public double getPercentage() {
		return percentage;
	}

	@Override
	public String toString() {
		return name + "-" + id + "-" + subject + "-" + percentage;
	}
}
