using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ManufacturingPhones.Model.Interface
{
    public interface ICallable
    {
        string Call(string phoneNumber);
    }
}
