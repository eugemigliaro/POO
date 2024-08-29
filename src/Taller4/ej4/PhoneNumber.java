package Taller4.ej4;

public class PhoneNumber implements Comparable<PhoneNumber>{
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber){
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public int compareTo(PhoneNumber other){
        int result = Integer.compare(areaCode, other.areaCode);
        if(result != 0){
            return result;
        }
        result = Integer.compare(prefix, other.prefix);
        if(result != 0){
            return result;
        }
        return Integer.compare(lineNumber, other.lineNumber);
    }

    @Override
    public String toString(){
        return "(" + areaCode + ") " + prefix + "-" + lineNumber;
    }

    public int getAreaCode(){
        return areaCode;
    }
    public int getPrefix(){
        return prefix;
    }
    public int getLineNumber(){
        return lineNumber;
    }
}
