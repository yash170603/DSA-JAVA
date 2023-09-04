class Solution {
    public List<String> letterCombinations(String digit)
     {
        
     int index =0;
     List<String> res = new ArrayList<>();
     String temp ="";
     String [] mapped = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
     func(index,res,temp,mapped,digit);
     return res;


    }
public void func(int index, List<String>res, String temp,String [] mapped, String digit)
{


   if(digit.length() ==0)
   return;
   
   
   if(index == digit.length())
   {
       res.add(temp);
       return;
   }

   int number = digit.charAt(index) -'0';
    if (number < 0 || number > 9) {
            return; // Invalid input, return early
        }
    String s = mapped[number];

    for(int i =0;i<s.length();i++)
    {
        temp += s.charAt(i);
        func(index+1, res, temp, mapped, digit);
        temp = temp.substring(0,temp.length()-1);
    }
   
   





}




}
