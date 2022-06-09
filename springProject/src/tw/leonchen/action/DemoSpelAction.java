package tw.leonchen.action;

import java.util.ArrayList;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import tw.leonchen.model.TruckBean;

public class DemoSpelAction {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression express1 = parser.parseExpression("'hola,' + ' Amigo !!'");
		String result1 = express1.getValue().toString();
		//String result1 = express1.getValue(String.class);
		System.out.println("result1:" + result1);
		
		Expression express2 = parser.parseExpression("2*5+1");
		int result2 = express2.getValue(Integer.class);
		System.out.println("result2:" + result2);
		
		EvaluationContext ectx = new StandardEvaluationContext();
		
        ArrayList<TruckBean> trucks = new ArrayList<TruckBean>();
        trucks.add(new TruckBean(1001,"subaru"));
        trucks.add(new TruckBean(1002,"Ferrari"));
        
        ectx.setVariable("trucks", trucks);
        
        String brand = parser.parseExpression("#trucks[0].brand").getValue(ectx, String.class);
        System.out.println("brand:" + brand);
	}

}
