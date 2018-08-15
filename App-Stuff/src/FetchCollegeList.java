import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FetchCollegeList{
	public static void main(String args[]) throws Exception{
	
		Document doc = Jsoup.connect("https://talk.collegeconfidential.com/alphabetic-list-colleges/").get();
		
		ArrayList<Element> links = doc.select("li[class^=Item]");
		
		ArrayList<String> colleges = new ArrayList<String>();
		
		for(Element row: links) {
			Elements elts = row.select("a[href^=https://talk.collegeconfidential.com/]");
			for(Element elt: elts) {
				//System.out.println(elt.text());	
				if(elt.text().length() > 1 && !elt.text().equals("X-Y-Z")) {
					colleges.add(elt.text());
				}
			}
		}
		
		//for(String c: colleges) {
		//	System.out.println(c);
		//}
				
		ArrayList<String> gpa = new ArrayList<String>();
		ArrayList<String> sat = new ArrayList<String>();
		ArrayList<String> act = new ArrayList<String>();
		
		ArrayList<String> location = new ArrayList<String>();
		ArrayList<String> size = new ArrayList<String>();
		ArrayList<String> gender = new ArrayList<String>();
		
		for(int i = 0; i < colleges.size(); i++){
			doc = Jsoup.connect("https://nces.ed.gov/collegenavigator/?q=" + colleges.get(i)).get();
			Elements elts = doc.select("table[id]");
			for(Element elt: elts) {
				System.out.println(elt.text());
			}
			System.out.println("done");
		}
		
		
		/*
		for(int i = 0; i < colleges.size(); i++) { //meat goes here, also may want to find location, e.t.c.
			doc = Jsoup.connect("https://www.google.com/search?q=" + colleges.get(i) + " act score").get();
			Elements elts = doc.select("div[class=\"Z0LcW\"]");
			System.out.print(colleges.get(i) + " ");
			for(Element elt: elts) {
				System.out.println(elt.text());
				act.add(elt.text());
			}
			if(elts.isEmpty()) {
				System.out.print("round 2: ");
				Elements nelts = doc.select("span[class=\"ILfuVd yZ8quc\"]");
				for(Element nelt: nelts) {
					Pattern p = Pattern.compile("ACT.*?(\\d\\d)");
					Matcher match = p.matcher(nelt.text());
					boolean mach = match.find();			
					
					if(mach) {
						System.out.println(match.group(1));
						act.add(match.group(1));
					}else{
						System.out.println("N/A");
						act.add("N/A");
					}
				
					
					//Elements smelts = nelt.select("b");
					//for(Element smelt: smelts) {
					//	System.out.println(smelt.text());
					//}
				}
				
				//System.out.println("N/A");
				//act.add("N/A");
			}
			
		}
		
		System.out.println("COLLEGES: " + colleges.size());
		System.out.println("ACT: " + act.size());
		
		System.out.println("blank: " + act.get(31));
		
		for(int i = 0; i < act.size(); i++) {
			//if() {
				
			//}
		}
		
				
		/*
		ArrayList<Element> links = doc.select("a[href^=https://talk.collegeconfidential.com/]");
		
		for(Element row: links) {
			System.out.print(row.elementSiblingIndex() + " ");
			System.out.println(row.text());
		}
		*/
		
		//for(Element row: doc.select("ul.DataList.CategoryTable.Collapsible tr")) {
			
		//}
		
		
		
		/*		Elements nelts = doc.select("span[class=\"ILfuVd yZ8quc\"]");
				for(Element nelt: nelts) {
					Elements smelts = nelt.select("b");
					for(Element smelt: smelts) {
						System.out.println(smelt.text());
					}
				}
		 */
		
	}
}
