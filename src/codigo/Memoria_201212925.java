package codigo;
import java.util.Random;
import java.util.Scanner;

/****************
*** @StormTK  ***
****************/
public class Memoria_201212925{

	public static void main(String[] args){
        Scanner Nombre = new Scanner(System.in);//Ingresa el Nombre del Jugador
        Scanner RealizarAccion = new Scanner(System.in);//Acepta realizar una acción
		Scanner Columna = new Scanner(System.in);//Ingresa el numero de Columna
        Scanner Fila = new Scanner(System.in);//Ingresa el Numero de fila
		Scanner Confirmar = new Scanner(System.in);//Confirma que acepta las columnas y filas
		Scanner Continuar = new Scanner(System.in);
		Scanner SeguirJugando = new Scanner(System.in);//Salir del programa
        
		String[][] MemoriaJuego = new String[4][5];//Memoria
               
        Random OpcionMatriz = new Random();//Creador de Random
        
		MjsBienvenida();
            
        //Ingresar el Nombre
        
               
		boolean Jugar = true;
		do{	

			System.out.println("Ingrese su nombre:");
			String NombrePJ = Nombre.nextLine();
			
			int NumMatriz = OpcionMatriz.nextInt(6+1);//Crear un numero Random
			GeneradorMemoria_201212925 Memoria = new GeneradorMemoria_201212925();//Declarar la clase Matriz
			Memoria.ValorMatriz(NumMatriz, MemoriaJuego);//Obtenga una matriz aleatoria
		
			int NumIntentos = 0;//Intentos
			int Parejas = 0;//Parejas 
			
			int numColumna = 0;
			int numFila = 0;
			
			int seleccion = 0;
			
			String comparar1 = "x";
			String comparar2 = "x";
			int Filop1 = 0;
			int Colop1 = 0;
			int Filop2 = 1;
			int Colop2 = 1;
			boolean compararNum = false;
			boolean uno = true;
			boolean dos = false;
			String [][] Volteado = {{"x","x","x","x","x"},{"x","x","x","x","x"},{"x","x","x","x","x"},{"x","x","x","x","x"}};
            do{  
				System.out.println("");
                System.out.println("*******************************************");
                System.out.println("  fila/col"+" 1 "+"  2 "+"  3 "+"  4 "+"  5 ");
		        System.out.println("    1     "+"["+Volteado[0][0]+"]"+" "+"["+Volteado[0][1]+"]"+" "+"["+Volteado[0][2]+"]"+" "+"["+Volteado[0][3]+"]"+" "+"["+Volteado[0][4]+"]");
		        System.out.println("    2     "+"["+Volteado[1][0]+"]"+" "+"["+Volteado[1][1]+"]"+" "+"["+Volteado[1][2]+"]"+" "+"["+Volteado[1][3]+"]"+" "+"["+Volteado[1][4]+"]");
		        System.out.println("    3     "+"["+Volteado[2][0]+"]"+" "+"["+Volteado[2][1]+"]"+" "+"["+Volteado[2][2]+"]"+" "+"["+Volteado[2][3]+"]"+" "+"["+Volteado[2][4]+"]");
		        System.out.println("    4     "+"["+Volteado[3][0]+"]"+" "+"["+Volteado[3][1]+"]"+" "+"["+Volteado[3][2]+"]"+" "+"["+Volteado[3][3]+"]"+" "+"["+Volteado[3][4]+"]");
		        System.out.println("   ---------------------------------");
		        System.out.println("          Jugador: "+NombrePJ);
		        System.out.println("            Parejas: "+Parejas);
		        System.out.println("        Intentos Fallidos: "+NumIntentos);
		        System.out.println("   ---------------------------------");
		        System.out.println("              Menu");
		        System.out.println("       Volterar Carta: V");
		        System.out.println("          Reiniciar: R");

				String AccionBoton = RealizarAccion.nextLine();
				
                if(AccionBoton.equals("V") || AccionBoton.equals("v")){
					do{
						System.out.println("Seleccione una Fila:");
						numFila = Fila.nextInt();
						if(numFila > 4 || numFila == 0){
							System.out.println("No existe ese no. de Fila en la Memoria");
						}
					}while(numFila < 1 || numFila > 4);
					do{
						System.out.println("Seleccione una Columna:");
						numColumna = Columna.nextInt();
						if(numColumna > 5 || numFila == 0){
							System.out.println("No existe ese no. de Columna en la Memoria");
						}
					}while(numColumna < 1 || numColumna > 5);
					
					System.out.println(".............................................");
					System.out.println("A seleccionado la Columna: " + numColumna + " Fila: " + numFila);
					System.out.println("Son Correcto estos Datos?");
					System.out.println("[Y/N]");
					
					String Confirmacion = Confirmar.nextLine();
					if(Confirmacion.equals("Y") || Confirmacion.equals("y")){
						
						if(dos == true){
							Filop2 = numFila - 1;
							Colop2 = numColumna - 1;
							comparar2 = MemoriaJuego[Filop2][Colop2];
							Volteado[Filop2][Colop2] = MemoriaJuego[Filop2][Colop2];
							compararNum = true;
							dos = false;
						}
						
						if(uno == true){
							Filop1 = numFila - 1;
							Colop1 = numColumna - 1;
							comparar1 = MemoriaJuego[Filop1][Colop1];
							Volteado[Filop1][Colop1] = MemoriaJuego[Filop1][Colop1];
							seleccion = 1;
							dos = true;
							uno = false;
						}
						
						if(" ".equals(comparar1)){
							uno = true;
							dos = false;
							System.out.println("Selecciono una carta vacia, vuelva a seleccionar otra...");
						}
						
						if(" ".equals(comparar2)){
							dos = true;
							compararNum = false;
							System.out.println("Selecciono una carta vacia vuelva a seleccionar otra...");
						}
						
						if((Filop1 == Filop2) && (Colop1 == Colop2)){
							compararNum = false;
							dos = true;
							System.out.println("Selecciono la misma Carta...");
							System.out.println("Seleccione de nuevo los valores de la segunda Carta");
						}
						
						if(compararNum == true){
							if(comparar1.equals(comparar2)){
								Parejas = Parejas + 1;
								System.out.println("*******************************************");
								System.out.println("  fila/col"+" 1 "+"  2 "+"  3 "+"  4 "+"  5 ");
								System.out.println("    1     "+"["+Volteado[0][0]+"]"+" "+"["+Volteado[0][1]+"]"+" "+"["+Volteado[0][2]+"]"+" "+"["+Volteado[0][3]+"]"+" "+"["+Volteado[0][4]+"]");
								System.out.println("    2     "+"["+Volteado[1][0]+"]"+" "+"["+Volteado[1][1]+"]"+" "+"["+Volteado[1][2]+"]"+" "+"["+Volteado[1][3]+"]"+" "+"["+Volteado[1][4]+"]");
								System.out.println("    3     "+"["+Volteado[2][0]+"]"+" "+"["+Volteado[2][1]+"]"+" "+"["+Volteado[2][2]+"]"+" "+"["+Volteado[2][3]+"]"+" "+"["+Volteado[2][4]+"]");
								System.out.println("    4     "+"["+Volteado[3][0]+"]"+" "+"["+Volteado[3][1]+"]"+" "+"["+Volteado[3][2]+"]"+" "+"["+Volteado[3][3]+"]"+" "+"["+Volteado[3][4]+"]");
								System.out.println("   ---------------------------------");
								System.out.println("          Jugador: "+NombrePJ);
								System.out.println("            Parejas: "+Parejas);
								System.out.println("        Intentos Fallidos: "+NumIntentos);
								System.out.println("   ---------------------------------");
								MemoriaJuego[Filop1][Colop1] = " ";
								MemoriaJuego[Filop2][Colop2] = " ";
								System.out.println("******* Has encontrado una Pareja *********");
								System.out.println("Presione enter para continuar...");
								String Enter = Continuar.nextLine();
							}
							else{
								NumIntentos = NumIntentos + 1;
								System.out.println("*******************************************");
								System.out.println("  fila/col"+" 1 "+"  2 "+"  3 "+"  4 "+"  5 ");
								System.out.println("    1     "+"["+Volteado[0][0]+"]"+" "+"["+Volteado[0][1]+"]"+" "+"["+Volteado[0][2]+"]"+" "+"["+Volteado[0][3]+"]"+" "+"["+Volteado[0][4]+"]");
								System.out.println("    2     "+"["+Volteado[1][0]+"]"+" "+"["+Volteado[1][1]+"]"+" "+"["+Volteado[1][2]+"]"+" "+"["+Volteado[1][3]+"]"+" "+"["+Volteado[1][4]+"]");
								System.out.println("    3     "+"["+Volteado[2][0]+"]"+" "+"["+Volteado[2][1]+"]"+" "+"["+Volteado[2][2]+"]"+" "+"["+Volteado[2][3]+"]"+" "+"["+Volteado[2][4]+"]");
								System.out.println("    4     "+"["+Volteado[3][0]+"]"+" "+"["+Volteado[3][1]+"]"+" "+"["+Volteado[3][2]+"]"+" "+"["+Volteado[3][3]+"]"+" "+"["+Volteado[3][4]+"]");
								System.out.println("   ---------------------------------");
								System.out.println("          Jugador: "+NombrePJ);
								System.out.println("            Parejas: "+Parejas);
								System.out.println("        Intentos Fallidos: "+NumIntentos);
								System.out.println("   ---------------------------------");
								Volteado[Filop1][Colop1] = "x";
								Volteado[Filop2][Colop2] = "x";
								System.out.println("****** No has encontrado una Pareja *******");
								System.out.println("Presione enter para continuar...");
								String Enter = Continuar.nextLine();
							}
							compararNum = false;
							uno = true;
						}
					}
				}
				if(AccionBoton.equals("R") || AccionBoton.equals("r")){
					NumIntentos = 7;
					System.out.println("****** Reiniciando *******");
					System.out.println(" ");
				}
				
            }while(NumIntentos < 3);
			if(NumIntentos == 3){
				System.out.println("************ Game Over ******************");
				System.out.println("Lo sentimos! Has Perdido");
				System.out.println("Deseas volver a Jugar?");
				System.out.println("[Y/N]");
				String Decidir = SeguirJugando.nextLine();
				if(Decidir.equals("Y") || Decidir.equals("y")){
					Jugar = true;
				}
				if(Decidir.equals("N") || Decidir.equals("n")){
					Jugar = false;
				}
			}
		}while(Jugar == true);
		System.out.println("Gracias Por Jugar!");
	}
	
	public static void MjsBienvenida(){
		//Inicio del Juego
        System.out.println("***********************");
        System.out.println("|| " + " Juego de Memoria " + "||");
        System.out.println("|| " + " by Kebyn Felipe " + " ||");
        System.out.println("***********************");
	}
	
}
