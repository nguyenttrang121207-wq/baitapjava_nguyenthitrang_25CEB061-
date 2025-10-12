public class heheheheh {
        private int day;
        private int month;
        private int year;
    public heheheheh( int d, int m, int y){
            this.day = d;
            this.month = m;
            this.year = y;
        }
        public void printday () {
            System.out.println("Day: " + day);
        }
        public void printMonth () {
            System.out.println("Month: " + month);
        }
        public void printYear () {
            System.out.println("Year: " + year);
        }
        public void printDate () {
            System.out.println("Date: " + this.day + "-" + this.month + "-" + this.year);
        }
    }
