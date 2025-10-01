package labassignments.lab06;
import java.io.*;
import java.util.*;

class Product implements Serializable {
    String name;
    int stock;
    int maxPerCustomer;
    double price;

    Product(String name, int stock, int max, double price) {
        this.name = name;
        this.stock = stock;
        this.maxPerCustomer = max;
        this.price = price;
    }

    public String toString() {
        return name + " | Stock: " + stock + " | Max/Customer: " + maxPerCustomer + " | Price: " + price;
    }
}

class Customer implements Serializable {
    String name;
    String phone;
    String productBought;
    int quantity;

    Customer(String name, String phone, String product, int qty) {
        this.name = name;
        this.phone = phone;
        this.productBought = product;
        this.quantity = qty;
    }

    public String toString() {
        return "Customer: " + name + " | Phone: " + phone + " | Bought: " + productBought + " (Qty: " + quantity + ")";
    }
}


public class q5 {
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();

        while (true) {
            System.out.println("\n--- COMPANY MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Customer Purchase");
            System.out.println("4. View Customers");
            System.out.println("5. Save & Exit");
            System.out.print("Choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        viewProducts();
                        break;
                    case 3:
                        customerPurchase();
                        break;
                    case 4:
                        viewCustomers();
                        break;
                    case 5:
                        saveData();
                        System.out.println("Data saved. Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void addProduct() {
        try {
            System.out.print("Product name: ");
            String name = sc.nextLine();

            System.out.print("Stock quantity: ");
            int stock = sc.nextInt();
            if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative");

            System.out.print("Max per customer: ");
            int max = sc.nextInt();
            if (max <= 0) throw new IllegalArgumentException("Max per customer must be positive");

            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (price < 0) throw new IllegalArgumentException("Price cannot be negative");

            products.add(new Product(name, stock, max, price));
            System.out.println("Product added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format!");
            sc.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    static void viewProducts() {
        try {
            if (products.isEmpty()) {
                System.out.println("No products available!");
                return;
            }

            System.out.println("\n--- PRODUCT LIST ---");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error viewing products: " + e.getMessage());
        }
    }

    static void customerPurchase() {
        try {
            if (products.isEmpty()) {
                System.out.println("No products available!");
                return;
            }

            System.out.print("Customer name: ");
            String name = sc.nextLine();

            System.out.print("Phone number: ");
            String phone = sc.nextLine();
            if (phone.length() != 10) {
                throw new IllegalArgumentException("Phone number must be 10 digits");
            }

            viewProducts();
            System.out.print("Select product (number): ");
            int prodIndex = sc.nextInt() - 1;

            if (prodIndex < 0 || prodIndex >= products.size()) {
                throw new IndexOutOfBoundsException("Invalid product selection");
            }

            Product p = products.get(prodIndex);

            System.out.print("Quantity: ");
            int qty = sc.nextInt();

            if (qty <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
            if (qty > p.maxPerCustomer) {
                throw new IllegalArgumentException("Cannot buy more than " + p.maxPerCustomer + " units");
            }
            if (qty > p.stock) {
                throw new IllegalArgumentException("Insufficient stock! Only " + p.stock + " available");
            }

            p.stock -= qty;
            customers.add(new Customer(name, phone, p.name, qty));

            double total = qty * p.price;
            System.out.println("Purchase successful! Total: Rs. " + total);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format!");
            sc.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid product selection!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error during purchase: " + e.getMessage());
        }
    }

    static void viewCustomers() {
        try {
            if (customers.isEmpty()) {
                System.out.println("No customer records!");
                return;
            }

            System.out.println("\n--- CUSTOMER LIST ---");
            for (Customer c : customers) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println("Error viewing customers: " + e.getMessage());
        }
    }

    static void saveData() {
        try {
            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("products.dat"));
            out1.writeObject(products);
            out1.close();

            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("customers.dat"));
            out2.writeObject(customers);
            out2.close();

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error while saving: " + e.getMessage());
        }
    }

    static void loadData() {
        try {
            File f1 = new File("products.dat");
            if (f1.exists()) {
                ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(f1));
                products = (ArrayList<Product>) in1.readObject();
                in1.close();
                System.out.println("Products loaded successfully!");
            }

            File f2 = new File("customers.dat");
            if (f2.exists()) {
                ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(f2));
                customers = (ArrayList<Customer>) in2.readObject();
                in2.close();
                System.out.println("Customers loaded successfully!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Data files not found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Data format mismatch!");
        } catch (Exception e) {
            System.out.println("Unexpected error while loading: " + e.getMessage());
        }
    }
}