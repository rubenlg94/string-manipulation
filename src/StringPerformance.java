public class StringPerformance {

    public static String toInsert = "ASMKDN MKANDMN AM";

    public static void main(String[] args) {
        concatStringsWithStringBuilder();
        concatStringsWithStringFormat();
        concatStringsWithPlusOperator();
        concatStringsWithConcatMethod();
        checkContains();
        checkEndsWith();
        convertToCamelCase();
    }

    public static void concatStringsWithStringBuilder() {
        long startAt = System.currentTimeMillis();
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(i);
        }
        result = stringBuilder.toString();
        long endAt = System.currentTimeMillis();
        System.out.println("Concatenating strings with String Builder took: " + (endAt - startAt) + "ms");
    }

    public static void concatStringsWithStringFormat() {
        long startAt = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result = String.format("%s%d", result, i);
        }
        long endAt = System.currentTimeMillis();
        System.out.println("Concatenating strings with String Format took: " + (endAt - startAt) + "ms");
    }

    public static void concatStringsWithPlusOperator() {
        long startAt = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result = result + i;
        }
        long endAt = System.currentTimeMillis();
        System.out.println("Concatenating strings with Plus Operator took: " + (endAt - startAt) + "ms");
    }

    public static void concatStringsWithConcatMethod() {
        long startAt = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result = result.concat(String.valueOf(i));
        }
        long endAt = System.currentTimeMillis();
        System.out.println("Concatenating strings with Concat Method took: " + (endAt - startAt) + "ms");
    }

    public static void checkContains() {
        long startAt = System.currentTimeMillis();
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i);
        }
        stringBuilder.append(toInsert);
        result = stringBuilder.toString();
        boolean contains = result.contains(toInsert);
        long endAt = System.currentTimeMillis();
        System.out.println("Ends with took: " + (endAt - startAt) + "ms");
    }

    public static void checkEndsWith() {
        long startAt = System.currentTimeMillis();
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (int i = 0; i < 10000000; i++) {
            stringBuilder.append(i);
        }
        stringBuilder.append(toInsert);
        result = stringBuilder.toString();
        boolean endsWith = result.endsWith(toInsert);
        long endAt = System.currentTimeMillis();
        System.out.println("Contains took: " + (endAt - startAt) + "ms");
    }

    private static void convertToCamelCase() {
        String toConvert = "I_NEED_TO_CONVERT_SOME_STRING_TO_CAMELCASE";
        String converted = toConvert.toLowerCase();
        for (int i = 0; i < converted.length(); i++) {
            if(converted.charAt(i) == '_'){
                converted = String.format("%s%s%s", converted.substring(0, i+1), String.valueOf(converted.charAt(i+1)).toUpperCase(), converted.substring(i+2));
            }
        }
        converted = converted.replaceAll("_", "");
        System.out.println(converted);
    }

}

