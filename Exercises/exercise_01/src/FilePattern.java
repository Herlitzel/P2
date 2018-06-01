import java.util.ArrayList;
import java.util.List;

/**
 * Filters file names using command-line wildcards.
 *
 * '*' matches any number of character.
 * '?' matches exactly one character.
 *
 * Examples:
 * '*.md' matches all files with the markdown extension.
 * 'exercise_??.md' matches, for example, 'exercise_01.md'.
 *
 * @author Nicolas Müller 17-122-094, Cedric Aebi 17-103-235
 *
 */
public class FilePattern {
	private String pattern;

	/**
	 * Creates a new instance of the FilePattern class that filters
	 * file names based on the given pattern.
	 *
	 * @param pattern the pattern used to filter file names.
	 * @see FilePattern
	 */
	public FilePattern(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * Returns whether the given filename matches this pattern.
	 * @param filename
	 * @return true if filename matches the pattern
	 */
	public boolean matches(String filename) {
		char[] patternChars = pattern.toCharArray();


		if(filename.length() < patternChars.length - 1) return false;
		if(patternChars.length == 1 && patternChars[0] == '*') return true;

		if(pattern.contains("*")) {
			int starposition;

			for(int i = 0; i < patternChars.length; i++) {
				if(patternChars[i] == '*') {
					starposition = i;
					pattern = String.valueOf(patternChars).replace("*", "");
					if(starposition+1 >= patternChars.length) return matches(filename.substring(0, i));
					else {
						while(i < filename.length() && filename.charAt(i) != '.') i++;
						return matches(filename.substring(0, starposition).concat(filename.substring(i)));
					}
				}
			}
		} else {

			if(pattern.length() != filename.length()) return false;

			for(int x = 0; x < patternChars.length; x++) {
				if(patternChars[x] != filename.charAt(x) && patternChars[x] != '?') return false;
			}
		}
		return true;

	}
}
