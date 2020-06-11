import java.util.Arrays;

public class Lab5 {
        public static class Letter {
        private char letter;
        public char getLetter() { return letter; }
        public void setLetter(char letter) { this.letter = letter; }
        public Letter (char letter) { this.letter = letter; }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Letter)) return false;
                Letter letter1 = (Letter) o;
                return Character.toLowerCase(getLetter()) == Character.toLowerCase(letter1.getLetter());
            }
        }
    public static class Word {
        private Letter[] letters;
        public Letter[] getLetters() { return letters; }
        public void setLetters(Letter[] letters) { this.letters = letters; }
        public int getSize() { return this.letters.length; }
        public Word() { this.letters = new Letter[0]; }
        public Word(char[] word) {
            this.letters = new Letter[word.length];
            for (int i = 0; i < word.length; i++) {
                this.letters[i] = new Letter(word[i]);
            }
        }
        public void AddLetter(Letter letter) {
            Letter[] temp = new Letter[this.letters.length + 1];
            System.arraycopy(this.letters, 0, temp, 0, this.letters.length);
            temp[this.letters.length] = letter;
            this.letters = temp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Word)) return false;
            Word word = (Word) o;
            return Arrays.equals(getLetters(), word.getLetters());
        }
    }
    public static class Mark {
        private char mark;
        public char getMark() { return mark; }
        public void setMark(char mark) { this.mark = mark; }
        public Mark(char mark) { this.mark = mark; }
    }
    public static class Str {
        private Word[] words;
        private Mark[] marks;
        private int size;

        public Str(char[] chars){
            this.words = new Word[0];
            this.marks = new Mark[0];
            Word word = new Word();
            this.size = 0;

            if (IsMark(chars[0]) || chars[0] == ' ') {
                AddMark(new Mark(chars[0]));
            }
            else {
                word.AddLetter(new Letter(chars[0]));
            }
            for (int i = 1; i < chars.length; i++) {
                if (IsMark(chars[i]) || chars[i] == ' ') {
                    if (chars[i - 1] != ' ') {
                        AddMark(new Mark(chars[i]));
                        if (word.getLetters().length != 0) {
                            AddWord(word);
                            word = new Word();
                        }
                    }
                }
                else {
                    word.AddLetter(new Letter(chars[i]));
                }
            }
            if (word.getSize() != 0) {
                AddWord(word);
            }

            for (Word value : this.words) {
                for (int j = 0; j < value.getSize(); j++) {
                    this.size++;
                }
            }
            this.size += this.marks.length;
        }

        public int getSize() { return size; }

        public void AddWord(Word word) {
            Word[] temp = new Word[this.words.length + 1];
            System.arraycopy(this.words, 0, temp, 0, this.words.length);
            temp[this.words.length] = word;
            this.words = temp;
        }
        public void AddMark(Mark mark) {
            Mark[] temp = new Mark[this.marks.length + 1];
            System.arraycopy(this.marks, 0, temp, 0, this.marks.length);
            temp[this.marks.length] = mark;
            this.marks = temp;
        }

        public char[] getCharArray() {
            char[] charArray = new char[this.size];
            int k = 0;
            for (int i = 0, l = 0; i < this.words.length; i++) {
                for (int j = 0; j < this.words[i].getSize(); j++) {
                    charArray[k++] = this.words[i].getLetters()[j].getLetter();
                }
                if (l < this.marks.length) {
                    if (this.marks[l].getMark() != ' ') {
                        charArray[k++] = this.marks[l++].getMark();
                        if (i != this.words.length - 1) {
                            charArray[k++] = ' ';
                            l++;
                        }
                    }
                    else {
                        charArray[k++] = this.marks[l++].getMark();
                    }
                }
            }
            return charArray;
        }

        public int[] count(char[][] words) {
            int[] counters = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                boolean in_str = false;
                for (int j = 0, k = 0; j < this.words.length; j++, k++) {
                    if (!in_str && this.words[j].equals(new Word(words[i]))) {
                        in_str = true;
                        counters[i]++;
                    }
                    if (k < this.marks.length && Is_end(this.marks[k].getMark())) {
                        k++;
                        in_str = false;
                    }
                }
            }
            return counters;
        }
    }

    public static boolean IsMark(char el) {
        switch (el) {
            case '?':
            case '!':
            case ',':
            case '.':
                return true;
            default:
                return false;
        }
    }

    public static boolean Is_end(char ch){
        switch (ch) {
            case '.':
            case '!':
            case '?':
                return true;
            default:
                return false;
        }

    }

    public static void main(String[] args) {
        String input = "Джеймс Гослинг родился 19 мая 1956 года в Канаде. " +
                "Окончил университет Альберты, а затем продолжил обучение в университете Карнеги-Меллона, где в 1973 году получил степень доктора философии по компьютерным наукам. " +
                "В начале 90-х годов в составе группы сотрудников фирмы Sun, известной под названием Green Team, " +
                "Джеймс Гослинг начинает работу над проблемами согласованности работы различных \"интеллектуальных\" " +
                "бытовых электромашин и приборов. К тому времени он уже разработал редактор cMacs и NeWS — оконный интерфейс для UNIX. " +
                "Гослинг сначала намеревался работать с C++, чтобы сделать его переносимым на разные платформы. " +
                "Однако он решил проблему переносимости, поместив разработанный им язык в \"виртуальную машину\". " +
                "Новый язык ОАК предназначался для *7 — удаленного устройства для контроля за работой всех \"интеллектуальных\" бытовых приборов, применяемых в домашнем хозяйстве. " +
                "Затем группа была переименована в First Person (\"Персона номер один\") и начала заниматься вопросами интерактивного телевидения.";
        Str str = new Str(input.toCharArray());

        char[][] words = {{'г','о','с','л','и','н', 'г'}, {'я','з','ы','к'}, {'д','ж','е','й','м','с'}};
        int[] counters = str.count(words);
        for (int counter : counters) {
            System.out.println(counter);
        }
        char[] res = str.getCharArray();
        for (char re : res) {
            System.out.print(re);
        }
    }
}
