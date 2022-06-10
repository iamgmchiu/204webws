package tw.leonchen.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logAdvice")
@Aspect
public class LogAdvice {
	
	@Pointcut(value = "execution(* tw.leonchen.model.HouseService.findBy*(..))")
	private void pointcut1() {}
	
	@Before(value = "pointcut1()")
	public void logBefore(JoinPoint point) {
		System.out.print("before: at " + point.getTarget().getClass() + " ");
		System.out.print("calling " + point.getSignature().getName() + " ");
		System.out.println("using " + point.getArgs()[0]);
		System.out.println("before: go into joinpoint method");
	}
	
	@Around(value = "pointcut1()")
	public Object logAround(ProceedingJoinPoint pPint) throws Throwable {
		System.out.print("around: at " + pPint.getTarget().getClass() + " ");
		System.out.print("calling " + pPint.getSignature().getName() + " ");
		System.out.println("using " + pPint.getArgs()[0]);
		Object result = pPint.proceed();
		System.out.println("result:" + result);
		return result;
	}
	
	@AfterReturning(pointcut = "pointcut1()", returning = "result")
	public void logAfter(JoinPoint point, Object result) {
		System.out.println("after: finish method");
		System.out.println("after result2:" + result);
	}
	
	@AfterThrowing(pointcut = "pointcut1()", throwing = "e")
	public void logThrow(JoinPoint point, Exception e) {
		System.out.println("Exception:" + e);
	}

}
