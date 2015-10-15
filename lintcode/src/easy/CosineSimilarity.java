package easy;

/**
 * @author: decaywood
 * @date: 2015/10/15 10:51
 *
 * Cosine similarity is a measure of similarity between two vectors of an inner product space that measures the cosine of the angle between them. The cosine of 0¡ã is 1, and it is less than 1 for any other angle.
 *
 * See wiki: Cosine Similarity
 *
 * Here is the formula:
 *
 * similarity = (A ¡¤ B) / (|A| * |B|)
 *
 * Given two vectors A and B with the same size, calculate the cosine similarity.
 *
 * Return 2.0000 if cosine similarity is invalid (for example A = [0] and B = [0]).
 *
 *
 */
public class CosineSimilarity {

    public double cosineSimilarity(int[] A, int[] B) {
        if(A.length == 0) return 2;
        double quadraticSumA = 0;
        double quadraticSumB = 0;
        double dotProduct = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            dotProduct += a * b;
            quadraticSumA += a * a;
            quadraticSumB += b * b;
        }
        return quadraticSumA == 0 || quadraticSumB == 0 ?
                2 : dotProduct / (Math.sqrt(quadraticSumA) * Math.sqrt(quadraticSumB));
    }


}
