package modelo;


public class CuadradoMagico 
{
	private int orden;
	private int cuadrado[][];
	
	public CuadradoMagico()
	{
		
	}
	
	public void setOrden(int orden)
	{
		this.orden = orden;
	}
	public int getOrden()
	{
		return orden;
	}
	public int[][] getCuadrado()
	{
		return cuadrado;
	}
	public void completarCuadrado(int x, int y, int sentido)
	{
		cuadrado = new int[getOrden()][ getOrden()];
		cuadrado[x][y] = 1;
		switch(sentido)
		{
			case 1:
				sentidoNO(x, y);
				break;
			case 2: 
				sentidoNE(x, y);
				break;
			case 3:
				sentidoSO(x, y);
				break;
			case 4:
				sentidoSE(x, y);
				break;
			default:
				System.out.println("dfd");
				break;
		}
	
	}
	public void sentidoNO(int x, int y)
	{
		
		int posX = x;
		int posY = y;
		int posXSinCambiar = x;
		int posYSinCambiar = y;
		int posXActual = posX;
		int posYActual = posY;
		for(int i=2; i<=(orden*orden); i++)
		{
			posX--;
			posY--;
			if(posX<0)
			{
				posX = cuadrado.length - 1;
			}
			if(posY<0)
			{
				posY = cuadrado.length - 1;
			}
			if(cuadrado[posX][posY] == 0)
			{
				cuadrado[posX][posY] = i;
			}
			else
			{
				if(posXSinCambiar == 0 && posYSinCambiar == cuadrado.length/2)
				{
					posY = posYActual;
					posX = posXActual + 1;
					cuadrado[posX][posY] = i;
				}
				else
				{
					posX = posXActual;
					posY = posYActual + 1;
					cuadrado[posX][posY] = i;
				}
			
				
			}
			posXActual = posX;
			posYActual = posY;
		}
	}
	public void sentidoNE(int  x, int y)
	{
		int posX= x;
		int posY = y;
		int posXSinCambiar = x;
		int posYSinCambiar = y;
		int posXActual = posX;
		int posYActual = posY;
		for(int i = 2; i<= orden*orden; i++)
		{
			posX--;
			posY++;
			if(posX < 0)
			{
				posX = cuadrado.length - 1;
			}
			if(posY > (cuadrado.length-1))
			{
				posY = 0;
			}
			if(cuadrado[posX][posY] == 0)
			{
				cuadrado[posX][posY] = i;
			}
			else
			{
				if(posXSinCambiar == 0 && posYSinCambiar == cuadrado.length/2)
				{
					posY = posYActual;
					posX = posXActual + 1;
					cuadrado[posX][posY] = i;
				}
				else
				{
					posX = posXActual;
					posY = posYActual -1;
					cuadrado[posX][posY] = i;
				}
			}
			posXActual = posX;
			posYActual = posY;
			
		}
	}
	public void sentidoSO(int x, int y)
	{
		cuadrado[x][y] = 1;
		int posX = x;
		int posY = y;
		int posXSinCambiar = x;
		int posYSinCambiar = y;
		int posXActual = posX;
		int posYActual = posY;
		
		for(int i = 2; i <= orden*orden; i++)
		{
			posX++;
			posY--;
			
			if(posX > (cuadrado.length -1))
			{
				posX = 0;
			}
			if(posY < 0)
			{
				posY = cuadrado.length - 1;
			}
			if(cuadrado[posX][posY] == 0)
			{
				cuadrado[posX][posY] = i;
			}
			else
			{
				if(posXSinCambiar == (cuadrado.length/2) && posYSinCambiar == 0)
				{
					posX = posXActual;
					posY = posYActual + 1;
					cuadrado[posX][posY] = i;
				}
				else
				{
					posX = posXActual - 1;
					posY = posYActual;
					cuadrado[posX][posY] = i;
				}
			}
			posXActual = posX;
			posYActual = posY;
		}
	}
	public void sentidoSE(int x, int y)
	{
		int posX = x;
		int posY = y;
		int posXSinCambiar = x;
		int posYSinCambiar = y;
		int posXActual = posX;
		int posYActual = posY;
		
		for(int i = 2; i <= orden*orden; i++)
		{
			posX++;
			posY++;
			
			if(posX > cuadrado.length -1)
			{
				posX = 0;
			}
			if(posY > cuadrado.length - 1)
			{
				posY = 0;
			}
			if(cuadrado[posX][posY] == 0)
			{
				cuadrado[posX][posY] = i;
			}
			else
			{
				if(posXSinCambiar == cuadrado.length/2 && posYSinCambiar == cuadrado.length-1)
				{
					posX = posXActual;
					posY = posYActual - 1;
					cuadrado[posX][posY] = i;
				}
				else
				{
					posX = posXActual - 1;
					posY = posYActual;
					cuadrado[posX][posY] = i;
				}
			}
			
			posXActual = posX;
			posYActual = posY;
		}
	}
}		
		
		
		