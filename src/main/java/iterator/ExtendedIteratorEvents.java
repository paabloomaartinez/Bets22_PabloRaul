package iterator;

import java.util.Vector;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator {

	private Vector<Event> events;
	private int i;
	
	public ExtendedIteratorEvents(Vector<Event> events) {
		this.events = events;
		i = 0;
	}
	
	@Override
	public boolean hasNext() {
		try {
			if(events.get(i) != null)
				return true;
			return false;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Object next() {
		i++;
		return events.get(i-1);
	}

	@Override
	public Object previous() {
		i--;
		return events.get(i+1);
	}

	@Override
	public boolean hasPrevious() {
		return hasNext();
	}

	@Override
	public void goFirst() {
		i = 0;
	}

	@Override
	public void goLast() {
		i = events.size()-1;
	}

	
}
