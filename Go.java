import java.util.Random;
public class Go{
	public static void main(String[] args)
	{
		
		Complex[] b = new Complex[50];
		Complex[] c;
		Double step = 1.0d;
		Random gen = new Random();
		double v = 1.0d;
		for(int i=0; i<b.length; i++)
		{
			b[i] = new Complex(2*Math.sin(4*v)+3*Math.cos(2*v), 0.0d);
			b[i] = new Complex(1/v, 0.0d);
			v += step;
		}
		Dft a = new Dft(b);
		a.transform();
	//	System.out.println(Double.compare(step,0.0d));
	//	System.out.println(Double.compare(0.0d,step));
		a.getMatlabCode(step,1.0d);
	}
}
