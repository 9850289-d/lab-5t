package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // --- 1. Конструктори ---

    // Конструктор без аргументів
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    // Конструктор з одним аргументом (загальна кількість хвилин)
    public TimeSpan(int totalMinutes) {
        if (totalMinutes < 0) {
            throw new IllegalArgumentException("Хвилини не можуть бути від'ємними.");
        }
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Конструктор з двома аргументами (години, хвилини)
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Час не може бути від'ємним.");
        }
        // Записуємо безпосередньо, а потім нормалізуємо
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    // Конструктор копіювання
    public TimeSpan(TimeSpan span) {
        this.hours = span.getHours();
        this.minutes = span.getMinutes();
    }

    // --- 2. Методи отримання значень ---

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    // --- Допоміжний приватний метод для нормалізації часу ---
    // Перераховує хвилини > 59 у години
    private void normalize() {
        if (this.minutes > 59) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    // --- 3. Перевантажені методи add() ---

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Час для додавання не може бути від'ємним.");
        }
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void add(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Хвилини не можуть бути від'ємними.");
        }
        this.minutes += minutes;
        normalize();
    }

    public void add(TimeSpan span) {
        this.hours += span.getHours();
        this.minutes += span.getMinutes();
        normalize();
    }

    // --- 4. Перевантажені методи subtract() ---

    public void subtract(int h, int m) {
        if (h < 0 || m < 0) {
            throw new IllegalArgumentException("Час для віднімання не може бути від'ємним.");
        }

        int currentTotal = this.getTotalMinutes();
        int subtractTotal = (h * 60) + m;

        if (subtractTotal <= currentTotal) {
            int newTotal = currentTotal - subtractTotal;
            this.hours = newTotal / 60;
            this.minutes = newTotal % 60;
        }
    }

    public void subtract(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Хвилини не можуть бути від'ємними.");
        }
        int currentTotal = this.getTotalMinutes();
        if (minutes <= currentTotal) {
            int newTotal = currentTotal - minutes;
            this.hours = newTotal / 60;
            this.minutes = newTotal % 60;
        }
    }

    public void subtract(TimeSpan span) {
        int currentTotal = this.getTotalMinutes();
        int subtractTotal = span.getTotalMinutes();

        if (subtractTotal <= currentTotal) {
            int newTotal = currentTotal - subtractTotal;
            this.hours = newTotal / 60;
            this.minutes = newTotal % 60;
        }
    }

    // --- 5. Повна тривалість інтервалу ---

    public double getTotalHours() {
        return this.hours + ((double) this.minutes / 60.0);
    }

    public int getTotalMinutes() {
        return (this.hours * 60) + this.minutes;
    }

    // --- 6. Масштабування інтервалу ---

    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Фактор масштабування має бути більшим за 0.");
        }
        int currentTotal = this.getTotalMinutes();
        int newTotal = currentTotal * factor;

        this.hours = newTotal / 60;
        this.minutes = newTotal % 60;
    }

    // Перевизначений метод toString() для зручної перевірки
    @Override
    public String toString() {
        return hours + " год " + minutes + " хв";
    }
}