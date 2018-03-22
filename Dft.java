class Dft{
	private Complex[] output;
	private Complex[] input;
	private double[] harmonic;
	Dft(Complex[] input)
	{
		this.input = input;
		output = new Complex[input.length];
		harmonic = new double[input.length/2+1];
	}

	public void transform()
	{
		int n = input.length;
		for(int k = 0; k < n; k++)
		{
			double sumreal = 0;
			double sumimag = 0;
			for(int t = 0; t < n; t++)
			{
				double angle = 2*Math.PI*t*k/n;
				sumreal += input[t].getReal() * Math.cos(angle) + input[t].getImag() * Math.sin(angle);
				sumimag += -input[t].getReal() * Math.sin(angle) + input[t].getImag() * Math.cos(angle); 
			}
			output[k] = new Complex(sumreal, sumimag);
		}
	}
	
	public void getMatlabCode(double step, double start)
	{
		int n = output.length;
		if(step < 1.0d)
		{
			System.out.println("% step < 0");
			System.out.println("n = ["+start+":"+step+":"+((n*step)-step)+"];");
		}
		else
		{
			System.out.println("%step > 0");
			System.out.println("n = ["+start+":"+step+":"+(n*step)+"];");
		}
		System.out.print("x = [ ");
		for(int i = 0; i<n; i++)
		{
			System.out.print(input[i].getReal()+ " ");
		}
		System.out.println("];");
		System.out.print("Xre = [ ");
		for(int i = 0; i<n; i++)
		{
			System.out.print(output[i].getReal()+ " ");
		}
		System.out.println(" ];");
		System.out.print("Xim = [ ");
		for(int i = 0; i<n; i++)
		{
			System.out.print(output[i].getImag()+ " ");
		}
		System.out.println(" ];");
		System.out.print("P = [ ");
		for(int i = 0; i<n/2+1; i++)
		{
			System.out.print((output[i].getReal() * output[i].getReal() + output[i].getImag() * output[i].getImag()) + " ");
		}
		System.out.println(" ];");
		System.out.println("subplot(3,1,1)");
		System.out.println("plot(n,x)");
		System.out.println("xlim(["+start+ " " + n*step + "])");
		System.out.println("subplot(3,1,2)");
		System.out.println("plot(n,Xre,n,Xim)");
		System.out.println("xlim(["+start+" " + n*step + "])");
		System.out.println("subplot(3,1,3)");
		System.out.println("stem([1:size(n,2)/2+1],P)");
//                if(step > 1.0d)
//                {
//               		 System.out.println("xlim(["+start+"  "])");
//                }
//                else
//                {
			System.out.println("xlim(["+start+" (size(n,2)*"+step+")/2+1])");
//		}
	}
	
	public Complex[] getResult()
	{
		return this.output;
	}

}
