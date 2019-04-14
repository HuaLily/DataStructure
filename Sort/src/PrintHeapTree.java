public class PrintHeapTree {
	
	int currentSize;
	
	int[] array;
	

	public PrintHeapTree(int[] array) {
		super();
		this.currentSize = array.length -1;
		this.array = array; 
	}

	public String printFancyTree()
	{
	    return printFancyTree(1, "");
	}

	private String printFancyTree(int index, String prefix)
	{
	    String outputString = "";

	    outputString = prefix + "|__";

	    if( index <= currentSize )
	    {
	        boolean isLeaf = index > currentSize / 2;

	        outputString += array[ index ] + "\n";
 
	        String _prefix = prefix;

	        if( index % 2 == 0 ) 
	            _prefix += "|  "; // one | and two spaces
	        else
	            _prefix += "   " ; // three spaces

	        if( !isLeaf )
	        {
	            outputString += printFancyTree( 2*index, _prefix);
	            outputString += printFancyTree( 2*index + 1, _prefix);
	        } 
	    }
	    else
	        outputString += "null\n";

	    return outputString;
	    }
}
