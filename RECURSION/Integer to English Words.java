class Solution {
    public Map<Integer,String> belowTen= Map.of( 0,"",1,"One",2,"Two",3,"Three",4,"Four",5,"Five",6,"Six",7,"Seven",8,"Eight",9,"Nine");
    public Map<Integer,String> belowTwenty=Map.of(10,"Ten",11,"Eleven",12,"Twelve",13,"Thirteen",14,"Fourteen",15,"Fifteen",16,"Sixteen",17,"Seventeen",18,"Eighteen",19,"Nineteen") ;
    public Map<Integer,String> belowHundred= Map.of(2,"Twenty",3,"Thirty",4,"Forty",5,"Fifty",6,"Sixty",7,"Seventy",8,"Eighty",9,"Ninety");

    public String numberToWords(int num) {
        if( num==0)
        return "Zero";

        return solve(num);
    }

    public String solve( int n){

        if( n< 10){
            return belowTen.get(n);
        }
        if( n<20){
            return belowTwenty.get(n);
        }
        if( n< 100){
            int tens= n/10;
           return belowHundred.get(tens)+  ((n%10!=0)?" "+ belowTen.get(n%10) :"");
        }
        if( n< 1000){
            int hundred= n/100;
            return solve(hundred)+" Hundred" + ((n%100!=0)?" "+solve(n%100) :"");
        }
        if( n<1000000){
            int thousands= n/1000;
            return solve(thousands)+" Thousand"+ ((n%1000!=0)?" "+solve(n%1000):"");
        }
        if(n<1000000000){
            int pos = n/1000000;
            return solve(pos)+ " Million"+ ((n%1000000!=0)?" "+solve(n%1000000):"");
        }

        return solve( n/1000000000)+" Billion"+((n%1000000000!=0)?" "+solve(n%1000000000):"");
    }
}
