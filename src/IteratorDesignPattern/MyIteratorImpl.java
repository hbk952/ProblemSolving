package IteratorDesignPattern;

import java.util.List;

public class MyIteratorImpl implements MyIterator{
	private List<User> userlist;
	private int length;
	private int position=0;
	
	public MyIteratorImpl(List<User> list) {
		this.userlist = list;
		this.length = list.size();
		
	}
	@Override
	public boolean hasNext() {
		if(position>=length) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public Object next() {
		User user = userlist.get(position);
		position+=1;
		return user;
	}

}
