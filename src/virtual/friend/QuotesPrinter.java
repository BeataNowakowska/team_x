package virtual.friend;

import java.util.ArrayList;

public class QuotesPrinter extends FunctionalityRunner {

	QuotesCreator creator = new QuotesCreator();

	public QuotesPrinter(ConsoleBox box) {
		super(box);
	}

	@Override
	public void next() {
		if (hasNextElement()) {
			String quota[] = arrayData.get(getNextElementIndex());
			console.write(creator.createQuote(quota[0], quota[1]));
		} else
			console.write(NODATA);
	}

	@Override
	public void setDataArrays(ArrayList<String[]> list) {
		this.arrayData = list;
	}
}
