using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Stealer
{
    public class Spy
    {
        public string StealFieldInfo(string investigatedClass, params string[] requestedFields)
        {
            Type classType = Type.GetType(investigatedClass);
            FieldInfo[] classFields = classType
                .GetFields(BindingFlags.Public | BindingFlags.Instance | BindingFlags.NonPublic | BindingFlags.Static);

            StringBuilder sb = new StringBuilder();

            Object classInstance = Activator.CreateInstance(classType, new object[] { });

            foreach (FieldInfo field in classFields.Where(f => requestedFields.Contains(f.Name)))
            {
                sb.AppendLine($"{field.Name} = {field.GetValue(classInstance)}");
            }

            return sb.ToString().Trim();
        }

        internal string AnalyzeAccessModifiers(string v)
        {
            throw new NotImplementedException();
        }
    }
}
