
package codes;



//import java.awt.List;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator 
{
	  public int  add(int x,int y) throws Exception {
		  int sum= this.ad(x);
		  return sum;
		 // return 1;
	 }
	  
	  private int ad(int x) throws Exception 
	  {
		return 1;
	}
	  
	  public  Calculator()
	  {
			
			number = new ArrayList<Double>();
			calculation = new ArrayList<Character>();
		  
	  }
	  

		
		private List<Double> number;
		private List<Character> calculation;
		private String text;

		public void s()
		{
			
		}

		public String calculate(String text) throws Exception {
		

			init();
		  if (getString(text)) {
				return sum() + "";
			} else {
				return "error";
			}
			
		}
			
		
	
		

		private double sum() {
	
			for (int i = 0; i < calculation.size(); i++) {
				char c = calculation.get(i);
				switch (c) {
				case '*':
					number.set(i, number.get(i) * number.get(i + 1));
					number.remove(i + 1);
					calculation.remove(i);
					i -= 1;
					break;
				case '/':
					number.set(i, (Double) number.get(i) / number.get(i + 1));
					number.remove(i + 1);
					calculation.remove(i);
					i -= 1;
					break;
				}
			}
	
			for (int i = 0; i < calculation.size(); i++) {
				char c = calculation.get(i);
				switch (c) {
				case '+':
					number.set(i, number.get(i) + number.get(i + 1));
					number.remove(i + 1);
					calculation.remove(i);
					i -= 1;
					break;
				case '-':
					number.set(i, (Double) number.get(i) - number.get(i + 1));
					number.remove(i + 1);
					calculation.remove(i);
					i -= 1;
					break;
				}
			}
	
			return number.get(0);
		}
	
		public void init() {
			number.clear();// 清空数组
			calculation.clear();
		}
	
		public boolean getString(String text) {
			this.text = text;
			if (check()) {
				setValue();
				return true;
			}
			return false;
		}

		private void setValue() {
			Pattern compile = Pattern.compile("\\d+");
			Matcher matcher = compile.matcher(text);
			while (matcher.find()) {
				number.add(Double.parseDouble(matcher.group()));
			}
			Pattern compile1 = Pattern.compile("[+-/*]");
			Matcher matcher1 = compile1.matcher(text);
			while (matcher1.find()) {
				calculation.add(matcher1.group().charAt(0));
			}
		}

		private boolean check() {
			if (text == null || !text.matches("[0-9+\\-*/]+"))
				return false;

			String regex = "\\d+";
			String regex1 = "[+\\-*/]+";
			if (findCount(text, regex1, 1) == -1)
				return false;
			return findCount(text, regex1, 1) == findCount(text, regex, 0) - 1;

		}

		private int findCount(String text, String regex, int len) {
			int count = 0;
			Pattern compile = Pattern.compile(regex);
			Matcher matcher = compile.matcher(text);

			while (matcher.find()) {
				count++;
				if (len > 0) {

					if (matcher.group().length() != len) {
						return -1;
					}

				}
			}
			return count;
		}

}
