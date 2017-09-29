package com.jesper.mvc;

import com.jesper.mvc.model.Member;
import com.jesper.mvc.view.MemberView;

public class Main {

	public static void main(String[] args) {
		Member member = new Member();
		member.setName("Jesper");
		member.setPersonalNumber(96);
		member.setId(1);
		MemberView mv = new MemberView();
		System.out.println(mv.viewCompact(member));
		System.out.println(mv.viewVerbose(member));
	}
}
