/*  remember 0 is the 0th fibb  term, 1 is the 1st fibbo, 1 again is the 2nd fibbo, 2 is the 3rd fibbo term */

public  int function(int n)
  {
  if(n<=1)
  return n;
int fsum = function(n-1);
int lsum = function(n-2);
return fsum+lastsum;
}

//watch strivers video once too.
//https://www.youtube.com/watch?v=kvRjNm4rVBE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=5.
