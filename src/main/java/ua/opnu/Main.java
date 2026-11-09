package ua.opnu;

public class Main {
    public static void main(String[] args) {
        // Висхідне перетворення (Upcasting)
        Person person = new Person("Шевченко", "Тарас", 45);
        Person student1 = new Student("Кашигін", "Дмитро", 19, "АІ-253", "KB123456");
        Person student2 = new Student("Коваленко", "Олена", 20, "АІ-253", "KB654321");
        Person lecturer = new Lecturer("Арсірій", "Олена", 45, "Інформаційних систем", 25000.0);

        // Створення масиву базового типу
        Person[] people = {person, student1, student2, lecturer};

        // Демонстрація поліморфізму
        System.out.println("--- Список людей ---");
        for (Person p : people) {
            // Java автоматично викликає правильний toString() для кожного об'єкта
            System.out.println(p.toString());
        }
    }
}