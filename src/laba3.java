import java.util.HashMap;
public class laba3 {
    public static void main(String[] args) {
        String text = new String("Джеймс Гослинг родился 19 мая 1956 года в Канаде. " +
                "Окончил университет Альберты, а затем продолжил обучение в университете Карнеги-Меллона, где в 1973 году получил степень доктора философии по компьютерным наукам. " +
                "В начале 90-х годов в составе группы сотрудников фирмы Sun, известной под названием Green Team, " +
                "Джеймс Гослинг начинает работу над проблемами согласованности работы различных \"интеллектуальных\" " +
                "бытовых электромашин и приборов. К тому времени он уже разработал редактор cMacs и NeWS — оконный интерфейс для UNIX. " +
                "Гослинг сначала намеревался работать с C++, чтобы сделать его переносимым на разные платформы. " +
                "Однако он решил проблему переносимости, поместив разработанный им язык в \"виртуальную машину\". " +
                "Новый язык ОАК предназначался для *7 — удаленного устройства для контроля за работой всех \"интеллектуальных\" бытовых приборов, применяемых в домашнем хозяйстве. " +
                "Затем группа была переименована в First Person (\"Персона номер один\") и начала заниматься вопросами интерактивного телевидения.");
        String[] allwords = text.split("[\\s+.—*,]");
        String[] words = new String[]{"Гослинг", "язык", "Джеймс"};
        HashMap<String, Integer> wordToCount = new HashMap<String, Integer>() {{
            put("Гослинг", 0); put("язык", 0); put("Джеймс", 0);
        }};
        for (String word : allwords) {
            if (wordToCount.containsKey(word))
            {
                wordToCount.put(word, wordToCount.get(word)+ 1);
            }}
        for (String word : wordToCount.keySet()) {
            System.out.println(word + " " + wordToCount.get(word));
        }

    }
}
