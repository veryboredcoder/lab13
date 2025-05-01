import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class lin_lab
{
    private ArrayList<Integer> numbers;

    public void readData(String filename)
    {
        numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String newLine;
            while ((newLine = br.readLine()) != null) {
                numbers.add(Integer.parseInt(newLine.trim()));  // Trim to handle whitespace
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            numbers = new ArrayList<>();  // Fallback empty list
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
            numbers = new ArrayList<>();  // Handle non-integer lines
        }
    }

    public long getTotalCount()
    {
        return numbers.stream().count();
    }

    public long getOddCount()
    {
        return numbers.stream().filter(n -> n % 2 != 0).count();
    }

    public long getEvenCount()
    {
        return numbers.stream().filter(n -> n % 2 == 0).count();
    }

    public long getDistinctGreaterThanFiveCount()
    {
        return numbers.stream().distinct().filter(n -> n > 5).count();
    }

    public Integer[] getResult1()
    {
        return numbers.stream().filter(n -> n > 5 && n < 50 && n % 2 == 0).sorted().toArray(Integer[]::new);
    }

    public Integer[] getResult2()
    {
        return numbers.stream().limit(50).map(n -> n * n * 3).toArray(Integer[]::new);
    }

    public Integer[] getResult3()
    {
        return numbers.stream().filter(n -> n % 2 != 0).map(n -> n * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
    }
}