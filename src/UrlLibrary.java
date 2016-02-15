import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrary implements Iterable<String> {

	private LinkedList<String> urls = new LinkedList<String>();

	private class UrlIterator implements Iterator<String> {

		private int index = 0;

		@Override
		public boolean hasNext() {
			// returns true if there is another url
			return index < urls.size();
			
			
			
			
			
			
			
			
			

		}

		@Override
		public String next() {
			StringBuilder sb = new StringBuilder();

			try {
				URL url = new URL(urls.get(index));

				BufferedReader br = new BufferedReader(new InputStreamReader(
						url.openStream()));
				String line = null;

				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}

				br.close();

			} catch (Exception e) {
				System.out.println("There was a problem with your file");
			}

			index++;
			return sb.toString();
		}

	}

	public UrlLibrary() {

		urls.add("http://www.yahoo.com");
		urls.add("http://www.time.com");
		urls.add("http://www.google.com");
		urls.add("http://www.youtube.com");
	}

	@Override
	public Iterator<String> iterator() {

		return new UrlIterator();
	}

	// @Override
	// public Iterator<String> iterator() {
	// return urls.iterator();
	// }

}
