class Complex{
  private double real;
  private double imag;

  Complex()
  {
    real = 0.0;
    imag = 0.0;
  }

  Complex(double r, double i)
  {
    real = r;
    imag = i;
  }

  public double getReal()
  {
    return real;
  }

  public double getImag()
  {
    return imag;
  }

  public void setReal(double real)
  {
    this.real = real;
  }

  public void setImag(double imag)
  {
    this.imag = imag;
  }

  public Complex conj()
  {
    return new Complex(real, -imag);
  }

  public String toString()
  {
    return "("+real+", "+imag+"i)";
  }
}
