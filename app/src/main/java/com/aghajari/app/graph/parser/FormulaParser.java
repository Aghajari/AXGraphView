package com.aghajari.app.graph.parser;

public class FormulaParser {

    private String savedFormula;
    private String formula;
    private int pos = -1, ch;

    public FormulaParser(String formula){
        this.savedFormula = formula;
        this.formula = formula;
    }

    public double parse(float x) {
        this.formula = this.savedFormula.replace("x",String.valueOf(x));
        return parse();
    }

    public double parse() {
        pos = -1; ch = 0;
        nextChar();
        double x = parseExpression();
        if (pos < formula.length()) throw new RuntimeException("Unexpected: " + (char)ch);
        return x;
    }


    private void nextChar() {
        ch = (++pos < formula.length()) ? formula.charAt(pos) : -1;
    }

    private boolean eat(int charToEat) {
        while (ch == ' ') nextChar();
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    private double parseExpression() {
        double x = parseTerm();
        for (;;) {
            if (eat('+')) {
                x += parseTerm(); // addition
            } else if (eat('-')){
                x -= parseTerm(); // subtraction
            } else return x;
        }
    }

    private double parseTerm() {
        double x = parseFactor();
        for (;;) {
            if (eat('*')) {
                x *= parseFactor(); // multiplication
            } else if (eat('/')) {
                x /= parseFactor(); // division
            } else return x;
        }
    }

    private double parseFactor() {
        if (eat('+')) return parseFactor(); // unary plus
        if (eat('-')) return -parseFactor(); // unary minus

        double x;
        int startPos = this.pos;
        if (eat('(')) { // parentheses
            x = parseExpression();
            eat(')');
        } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            x = Double.parseDouble(formula.substring(startPos, this.pos));
        } else if (ch >= 'a' && ch <= 'z') { // functions
            while (ch >= 'a' && ch <= 'z') nextChar();
            String func = formula.substring(startPos, this.pos);
            x = parseFactor();
            x = parseFunctions(func,x);
        } else {
            throw new RuntimeException("Unexpected: " + (char)ch);
        }

        if (eat('^'))
            x = Math.pow(x, parseFactor()); // exponentiation

        return x;
    }

    private double parseFunctions(String func,double x){
        switch (func.toLowerCase()) {
            case "sqrt":
                x = Math.sqrt(x);
                break;
            case "sin":
                x = Math.sin(x);
                break;
            case "cos":
                x = Math.cos(x);
                break;
            case "tan":
                x = Math.tan(x);
                break;
            case "cot":
                x = 1/Math.tan(x);
                break;
            case "log":
                x = Math.log(x);
                break;
            default:
                throw new RuntimeException("Unknown function: " + func);
        }
        return x;
    }
}
