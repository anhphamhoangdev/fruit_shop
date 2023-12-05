//package Util;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ProductRecommendation {
//
//    // Map to store product vectors
//    private Map<String, double[]> productVectors;
//
//    // Constructor to initialize product vectors (you should populate this based on your data)
//    public ProductRecommendation() {
//        productVectors = new HashMap<>();
//
//        // Example product vectors (replace these with your actual vectors)
//        double[] vector1 = {1.0, 0.5, 0.2};
//        double[] vector2 = {0.8, 0.6, 0.3};
//
//        productVectors.put("Product1", vector1);
//        productVectors.put("Product2", vector2);
//        // Add more products and their vectors as needed
//    }
//
//    // Function to calculate cosine similarity between two vectors
//    private double cosineSimilarity(double[] vector1, double[] vector2) {
//        double dotProduct = 0.0;
//        double norm1 = 0.0;
//        double norm2 = 0.0;
//
//        for (int i = 0; i < vector1.length; i++) {
//            dotProduct += vector1[i] * vector2[i];
//            norm1 += Math.pow(vector1[i], 2);
//            norm2 += Math.pow(vector2[i], 2);
//        }
//
//        if (norm1 == 0 || norm2 == 0) {
//            return 0.0; // To handle division by zero
//        }
//
//        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
//    }
//
//    // Function to recommend products based on cosine similarity
//    public String recommendProduct(String targetProduct) {
//        double maxSimilarity = -1.0;
//        String recommendedProduct = null;
//
//        double[] targetVector = productVectors.get(targetProduct);
//
//        if (targetVector != null) {
//            for (Map.Entry<String, double[]> entry : productVectors.entrySet()) {
//                if (!entry.getKey().equals(targetProduct)) {
//                    double similarity = cosineSimilarity(targetVector, entry.getValue());
//                    if (similarity > maxSimilarity) {
//                        maxSimilarity = similarity;
//                        recommendedProduct = entry.getKey();
//                    }
//                }
//            }
//        }
//
//        return recommendedProduct;
//    }
//
//    public static void main(String[] args) {
//        ProductRecommendation recommendation = new ProductRecommendation();
//
//        // Example: Recommend a product similar to "Product1"
//        String recommendedProduct = recommendation.recommendProduct("Product1");
//
//        System.out.println("Recommended Product: " + recommendedProduct);
//    }
//
//        public Map<String, double[]> createProductVectors(List<Invoice> invoices) {
//            Map<String, double[]> productVectors = new HashMap<>();
//
//            for (Invoice invoice : invoices) {
//                Collection<LineItem> lineItems = invoice.getLineItem();
//
//                for (LineItem lineItem : lineItems) {
//                    String productName = lineItem.getItem().getName();
//
//                    // If the product is not in the map, add it with initial values
//                    if (!productVectors.containsKey(productName)) {
//                        double[] vector = {0.0, 0.0}; // Index 0: Total quantity sold, Index 1: Total revenue
//                        productVectors.put(productName, vector);
//                    }
//
//                    // Update the vector for the current product
//                    double[] currentVector = productVectors.get(productName);
//                    currentVector[0] += lineItem.getQuantity(); // Accumulate quantity
//                    currentVector[1] += lineItem.getQuantity() * lineItem.getItem().getPrice(); // Accumulate revenue
//                }
//            }
//
//            return productVectors;
//        }
//
//        public static void main(String[] args) {
//            ProductProcessor productProcessor = new ProductProcessor();
//            List<Invoice> invoices = InvoiceDB.selectInvoice();
//
//            // Create product vectors based on invoices
//            Map<String, double[]> productVectors = productProcessor.createProductVectors(invoices);
//
//            // Print the resulting product vectors
//            System.out.println("Product Vectors:");
//            for (Map.Entry<String, double[]> entry : productVectors.entrySet()) {
//                String productName = entry.getKey();
//                double[] vector = entry.getValue();
//                System.out.println("Product: " + productName + ", Vector: [" + vector[0] + ", " + vector[1] + "]");
//            }
//        }
//
//
//}
