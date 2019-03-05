public class Main {
    public static void main(String[] args) {
        /*
        *   Завдання 1
        *   Дано рядок зі слів, розділених пробілом.
        *   Поміняти місцями в кожному слові першу та останню букву.
        *   Вивести результат на екран.
         */
        String str = "Hello аб в г World my name is Oleksandr";
        if (!str.substring(str.length() - 1).equalsIgnoreCase(" ")) str += " ";
        System.out.println("\tЗавдання 1\nВхідний рядок:\n" + str); //Виведення початкового рядка
        char[] strToChar = str.toCharArray(); //Переведення рядка в масив символів
        str = "";
        char[] buffer = new char[strToChar.length];
        int j = 0;

        for (int i = 0; i < strToChar.length; ++i){
            if (strToChar[i] == ' '){
                //Перший символ buffer міняється місцями з останнім
                buffer[j] = buffer[0];
                buffer[0] = buffer[j - 1];
                buffer[j - 1] =  buffer[j];
                //До str додається buffer
                //substring(0, j) використовується, щоб додати лише нове записане слово
                //оскільки buffer не очищується і може зберігати символи з попередніх слів
                str += new String(buffer).substring(0, j) + " ";
                j = 0;
            }
            else {
                buffer[j++] = strToChar[i]; //В buffer записується слово до пробілу
            }
        }
        System.out.println("Вихідний рядок:\n" + str); //Виведення кінцевого рядка


        /*
         *   Завдання 2
         *   Дано рядок зі слів, розділених пробілами.
         *   Використовуючи StringBuilder розставити слова у такому порядку,
         *   щоб остання буква даного слова збігалася з першою літерою наступного без урахування регістру.
         */
        StringBuilder str1 = new StringBuilder("Олександр Криса гулевич риба Київ Іващенко Василь аисак"); // Вхідний/вихідний рядок
        if (!str1.substring(str1.length() - 1).equalsIgnoreCase(" ")) str1.append(" "); //Додаємо пробіл в кінець рядка, щоб потім при записі слів в масив останнє слово теж записалося
        System.out.println("\n\tЗавдання 2\nВхідний рядок:\n" + str1); //Виведення початкового рядка
        int str1Length = str1.length();
        j = 0;
        for (int i = 0; i < str1Length; ++i)
            if (str1.substring(i, i + 1).equals(" ")) ++j; //Знаходимо к-ть пробілів у рядку, що також означатиме к-ть слів (пробілів може бути і більше)

        String[] words = new String[j]; //Створюємо масив для збереження слів (для зручної роботи зі словами)
        int k = 0;
        j = 0;
        for (int i = 0; i < str1Length; ++i) { //В цьому циклі переносимо слова з одного рядка в масив рядків
            if (!str1.substring(k, k + 1).equals(" ")) {
                k++;
            }
            else {
                words[j++] = str1.substring(0, k); //Записуємо слово в масив
                str1.delete(0, k + 1); //Видаляємо слово з рядка
                k = 0;
            }
        }

        str1 = new StringBuilder(words[0]); //В рядок записуємо перше слово з масиву
        for(int i = 1; i < j; ++i){
            /*Порівнюємо першу букву і-того слова масиву з останнью буквою рядка*/
            if((words[i].substring(0, 1)).equalsIgnoreCase(str1.substring(str1.length() - 1)) && !words[i].equals(" ")) {
                /*Ставимо і-те слово в кінець рядка*/
                str1.append(" " + words[i]); //До рядка додаємо і-те слово масива
                words[i] = " "; //Саме слово очищуємо
                i = 1; //Починаємо ітерацію з одиниці, щоб знову перевірити всі слова

            }
            /*Порівнюємо останню букву і-того слова з першою буквою рядка*/
            else if((words[i].substring(words[i].length() - 1)).equalsIgnoreCase(str1.substring(0, 1)) && !words[i].equals(" ")){
                /*Ставимо і-те слово на початок рядка*/
                StringBuilder buf = new StringBuilder(words[i] + " "); //Записуємо його з пробілом в буферну змінну
                str1 = buf.append(str1); //Додаємо до неї рядок і перезаписуємо в рядок
                words[i] = " "; //Саме слово очищуємо
                i = 1; //Починаємо ітерацію з одиниці, щоб знову перевірити всі слова
            } //Цикл буде працювати до того часу, поки всі слова не відсортується (жодна ітерація не попаде в жоден з if-ів)
        }
        for(int i = 1; i < j; ++i) { //Цей цикл додає в рядок слова, які залишилися (не пройшли провірку в попередньому циклі) в кінець рядка
            if(!words[i].equals(" ")){
                str1.append(" " + words[i]);
            }
        }
        System.out.println("Вихідний рядок:\n" + str1); //Виведення кінцевого рядка
    }
}