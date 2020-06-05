package deleteme.calculadora.component;

public class CalculadoraEngine {
    
    public String calcular(String primerOperando, String operador, String segundoOperando, String calcular) {
    	try {
    		Double res;
    		switch(operador) {
    			case "+":
	    		case "suma":
	    		     res = Double.parseDouble(primerOperando)+Double.parseDouble(segundoOperando);
	    		     break;
	    		case "-":
	    		case "resta":
	    			res = Double.parseDouble(primerOperando)-Double.parseDouble(segundoOperando);
	    			break;
	    		case "*":
	    		case "multiplicacion":
	    			res = Double.parseDouble(primerOperando)*Double.parseDouble(segundoOperando);
	    			break;
	    		case "/":
	    		case "division":
	    			res = Double.parseDouble(primerOperando)/Double.parseDouble(segundoOperando);
	    			break;
	    		default:
	    			res = 0D;		
    		}
    		return res.toString();
    	}catch (Exception e) {
			return "ERROR AL REALIZAR LA OPERACION "+e;
		}
    }

}