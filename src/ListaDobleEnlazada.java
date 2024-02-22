import java.util.Scanner;

class NodoDoble {
    int dato;
    NodoDoble siguiente;
    NodoDoble anterior;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

public class ListaDobleEnlazada {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tamanio;

    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    public void insertarAlInicio(int dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }

        tamanio++;
    }

    public void insertarAlFinal(int dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }

        tamanio++;
    }

    public void recorrerHaciaAdelante() {
        NodoDoble temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    public void recorrerHaciaAtras() {
        NodoDoble temp = cola;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.anterior;
        }
        System.out.println();
    }

    public int obtenerTamanio() {
        return tamanio;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int buscarPorValor(int valor) {
        NodoDoble temp = cabeza;
        int indice = 0;

        while (temp != null) {
            if (temp.dato == valor) {
                return indice;
            }
            temp = temp.siguiente;
            indice++;
        }

        return -1;
    }

    public int buscarPorIndice(int indice) {
        if (indice < 0 || indice >= obtenerTamanio()) {
            return -1;
        }

        NodoDoble temp = cabeza;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }

        return temp.dato;
    }

    public void borrarElemento(int valor) {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
            tamanio--;
            return;
        }

        if (cola.dato == valor) {
            cola = cola.anterior;
            cola.siguiente = null;
            tamanio--;
            return;
        }

        NodoDoble temp = cabeza;
        while (temp != null) {
            if (temp.dato == valor) {
                temp.anterior.siguiente = temp.siguiente;
                temp.siguiente.anterior = temp.anterior;
                tamanio--;
                return;
            }
            temp = temp.siguiente;
        }

        System.out.println("Elemento no encontrado en la lista");
    }

    public static void main(String[] args) {
        ListaDobleEnlazada listaDoble = new ListaDobleEnlazada();
        Scanner scanner = new Scanner(System.in);
        int opcion, dato, indice, valor;

        while (true) {
            System.out.println("\nLista Doblemente Enlazada");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Recorrer hacia adelante");
            System.out.println("4. Recorrer hacia atrás");
            System.out.println("5. Mostrar tamaño de la lista");
            System.out.println("6. Mostrar si la lista está vacía");
            System.out.println("7. Buscar elemento por valor");
            System.out.println("8. Buscar elemento por índice");
            System.out.println("9. Borrar un elemento");
            System.out.println("10. Salir");

            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato a insertar al inicio: ");
                    dato = scanner.nextInt();
                    listaDoble.insertarAlInicio(dato);
                    break;
                case 2:
                    System.out.print("Ingrese el dato a insertar al final: ");
                    dato = scanner.nextInt();
                    listaDoble.insertarAlFinal(dato);
                    break;
                case 3:
                    System.out.println("Recorriendo hacia adelante:");
                    listaDoble.recorrerHaciaAdelante();
                    break;
                case 4:
                    System.out.println("Recorriendo hacia atrás:");
                    listaDoble.recorrerHaciaAtras();
                    break;
                case 5:
                    System.out.println("Tamaño de la lista: " + listaDoble.obtenerTamanio());
                    break;
                case 6:
                    System.out.println("La lista está vacía: " + listaDoble.estaVacia());
                    break;
                case 7:
                    System.out.print("Ingrese el valor a buscar: ");
                    valor = scanner.nextInt();
                    indice = listaDoble.buscarPorValor(valor);
                    if (indice != -1) {
                        System.out.println("Elemento encontrado en el índice " + indice);
                    } else {
                        System.out.println("Elemento no encontrado en la lista");
                    }
                    break;
                case 8:
                    System.out.print("Ingrese el índice a buscar: ");
                    indice = scanner.nextInt();
                    valor = listaDoble.buscarPorIndice(indice);
                    if (valor != -1) {
                        System.out.println("Elemento en el índice " + indice + ": " + valor);
                    } else {
                        System.out.println("Índice no válido");
                    }
                    break;
                case 9:
                    System.out.print("Ingrese el valor a borrar: ");
                    valor = scanner.nextInt();
                    listaDoble.borrarElemento(valor);
                    break;
                case 10:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
