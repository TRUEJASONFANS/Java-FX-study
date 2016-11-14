import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.junit.Test;
import org.zhxie.javafx.property.Book;
public class PropertyAndBindingTest  {

	public static void main(String[] args) {
		
		//StringBinding
		StringProperty str1 = new SimpleStringProperty("11");
		StringProperty str2 = new SimpleStringProperty("22");
		StringProperty str3 = new SimpleStringProperty("33");
		str3.bind(str1.concat(str2));
		System.out.println(str3.get());
		
		StringExpression desc = str1.concat(str2);
		
		System.out.println(desc.get());
		str2.set("33");
		System.out.println(desc.get());
		StringBinding strBinding = new StringBinding() {
			{
				bind(str1.concat(str2));
			}
  
			@Override
			protected String computeValue() {
				return str1.concat(str2).get();
			}};
	    System.out.println("StringBinding: + " + strBinding.getValue());
	    str2.set("22");
	    System.out.println("StringBinding: + " + strBinding.getValue());
		
		//NumberBinding
		IntegerProperty digit1 = new SimpleIntegerProperty(1);
		IntegerProperty digit2 = new SimpleIntegerProperty(2);
		NumberBinding sum = digit1.add(digit2);
	    System.out.println("sum.isValid(): " + sum.isValid());
		System.out.println(sum.getValue());
	    System.out.println("sum.isValid(): " + sum.isValid());
		digit1.set(3);
	    System.out.println("sum.isValid(): " + sum.isValid());
	    
	    
	    //BooleanBinding
	    BooleanProperty b1 = new SimpleBooleanProperty(true);
	    BooleanProperty b2 = new SimpleBooleanProperty(true);
	    
	    
	    
	    //ObjectBinding
	    ObjectProperty<Book> ob1 = new SimpleObjectProperty<Book>(new Book());
	    ObjectProperty<Book> ob2 = new SimpleObjectProperty<Book>(new Book());
	
	}

	
	@Test 
	public void testBooleanBinding() {
		Book b1 = new Book("J1", 90, "1234567890");
		Book b2 = new Book("J2", 80, "0123456789");
		ObjectProperty<Book> book1 = new SimpleObjectProperty<>(b1);
		ObjectProperty<Book> book2 = new SimpleObjectProperty<>(b2);
		// Create a binding that computes if book1 and book2 are equal
		BooleanBinding isEqual = book1.isEqualTo(book2);
		System.out.println(isEqual.get());
		book2.set(b1);
		System.out.println(isEqual.get());
	}
}
