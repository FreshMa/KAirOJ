import java.util.regex.Matcher;
import java.util.regex.Pattern;
//ip地址的规则：
//1) 点分地址，四个部分，三个点
//2) 每个部分的值范围是0~255
//3) 每个部分数字出现次数不超过3次
//4) 假设每个部分由三个数字组成，当第一个数字是0或1时，其余数字可以是任意数字；当第一个数字是2时，其余数字不能超过5
public class HelloWorld {
	public static int n=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dotRegex = "[\\d]{0,3}\\.[\\d]{0,3}\\.[\\d]{0,3}\\.[\\d]{0,3}";
		String IPRegex = "[01]?\\d?\\d?";
		String IPRegex2 = "[2]?[0-5]?[0-5]?";
		
		String [] strings = null;
		
		String IP = "333.3.3.211";
		
		boolean isIP = true;
		
		Pattern p = Pattern.compile(dotRegex);
		Pattern p1 = Pattern.compile(IPRegex);
		Pattern p2 = Pattern.compile(IPRegex2);
		
		Matcher m = p.matcher(IP);
		
		System.out.println(m.matches());
		if(m.matches()){
			strings = IP.split("\\.");
			for(String s:strings){
				
				Matcher m1 = p1.matcher(s);
				Matcher m2 = p2.matcher(s);
				
				if(!m1.matches()&&!m2.matches()){
					isIP = false;
					break;
				}
					
			}
		}
		else{
			isIP = false;
		}
		
		String result = isIP?"Y":"N";
		System.out.println(result);
	}
}
