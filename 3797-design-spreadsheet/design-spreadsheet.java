class Spreadsheet {

    int[][] sheet;

    public Spreadsheet(int rows) {
        this.sheet = new int[rows+1][26];
    }
    
    public void setCell(String cell, int value) {
        int col = (cell.charAt(0)-'A');
        int row = Integer.valueOf(cell.substring(1));
        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = (cell.charAt(0)-'A');
        int row = Integer.valueOf(cell.substring(1));
        sheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        String x = "", y ="";
        boolean num1 = true;
        int result = 0;
        for(int i=1;i<formula.length();i++){
            if(formula.charAt(i)=='+') num1 = false;
            else if(num1) x += formula.charAt(i);
            else y+=formula.charAt(i);
        }

        if(x.charAt(0) >= '0' && x.charAt(0) <='9'){
            result += Integer.valueOf(x);
        }else{
            int col = (x.charAt(0)-'A');
            int row = Integer.valueOf(x.substring(1));
            result += sheet[row][col];
        }
        if(y.charAt(0) >= '0' && y.charAt(0) <='9'){
            result += Integer.valueOf(y);
        }else{
            int col = (y.charAt(0)-'A');
            int row = Integer.valueOf(y.substring(1));
            result += sheet[row][col];
        }

        return result;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */