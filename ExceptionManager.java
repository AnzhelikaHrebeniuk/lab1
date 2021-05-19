import java.util.List;

//cтворюємо клас
public class ExceptionManager {
	
	//ініціалізуємо лічильники та List
	private final List<Class<? extends Exception>> criticalExceptions;
	private long criticalExceptionsCounter;
	private long usualExceptionsCounter;
	
	//створюємо конструктор
	public ExceptionManager(List<Class<? extends Exception>> criticalExceptions) {
		this.criticalExceptions = criticalExceptions;
	}
	
	//створюємо метод, який перевіряє на критичність
	public boolean isCritical(Exception exception) {
		Class<?> exceptionClass = exception.getClass();
		for (var criticalExceptionClass : criticalExceptions) {
			if (criticalExceptionClass.isAssignableFrom(exceptionClass)) { 
				return true;
			}
		}
		
		return false;
	}
	
	//збільшення лічильників
	
	public boolean checkAndIncrementCounter(Exception exception) {
		boolean isCritical = isCritical(exception);
		if (isCritical)
			criticalExceptionsCounter++;
		else
			usualExceptionsCounter++;
		
		return isCritical;
	}
	
	public long getCriticalExceptionsCounter() {
		return criticalExceptionsCounter;
	}
	
	public long getUsualExceptionsCounter() {
		return usualExceptionsCounter;
	}
}
