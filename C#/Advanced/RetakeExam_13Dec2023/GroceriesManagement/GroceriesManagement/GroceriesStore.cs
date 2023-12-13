using System.Text;

namespace GroceriesManagement
{
    public class GroceriesStore
    {
        public GroceriesStore(int capacity)
        {
            Capacity = capacity;
            Turnover = 0;
            Stall = new List<Product>();
        }

        public int Capacity { get; private set; }
        public double Turnover { get; private set; }
        public List<Product> Stall { get; private set; }

        public void AddProduct(Product product)
        {
            if (Capacity > Stall.Count)
            {
                Product foundproduct = Stall.FirstOrDefault(p => p.Name == product.Name);

                if (foundproduct == null)
                {
                    Stall.Add(product);
                }
            }
        }

        public bool RemoveProduct(string name)
        {
            return Stall.Remove(Stall.FirstOrDefault(p => p.Name == name));
        }

        public string SellProduct(string name, double quantity)
        {
            Product product = Stall.FirstOrDefault(p => p.Name == name);

            if (product != null)
            {
                double totalPrice = product.Price * quantity;
                Turnover += Math.Round(totalPrice, 2);
                return $"{product.Name} - {totalPrice:F2}$";
            }
            else
            {
                return "Product not found";
            }
        }

        public string GetMostExpensive()
        {
            return Stall.MaxBy(product => product.Price).ToString();
        }

        public string CashReport()
        {
            return $"Total Turnover: {Turnover:F2}$";
        }

        public string PriceList()
        {
            StringBuilder result = new StringBuilder();
            result.AppendLine("Groceries Price List:");

            foreach (Product product in Stall)
            {
                result.AppendLine(product.ToString());
            }

            return result.ToString().TrimEnd();   
        }
    }
}
