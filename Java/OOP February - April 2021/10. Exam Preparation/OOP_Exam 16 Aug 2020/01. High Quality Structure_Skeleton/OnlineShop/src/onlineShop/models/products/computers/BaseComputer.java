package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;


    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String toString() {
        double sumOverallPerformancePeripherals = 0;
        double averageOverallPerformancePeripherals = 0;

        for (Peripheral peripheral : this.peripherals) {
            sumOverallPerformancePeripherals += peripheral.getOverallPerformance();
        }

        averageOverallPerformancePeripherals = sumOverallPerformancePeripherals / this.peripherals.size();

        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(System.lineSeparator())
                .append(" ").append(String.format(OutputMessages.COMPUTER_COMPONENTS_TO_STRING, this.components.size()));

        for (Component component : this.components) {
            sb.append(System.lineSeparator()).append("  ").append(component);
        }

        sb.append(System.lineSeparator())
                .append(" ").append(String.format(OutputMessages.COMPUTER_PERIPHERALS_TO_STRING,
                this.peripherals.size(), averageOverallPerformancePeripherals));

        for (Peripheral peripheral : this.peripherals) {
            sb.append(System.lineSeparator()).append("  ").append(peripheral);
        }

        return sb.toString().trim();
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        }

        double sumOverallPerformanceComponents = 0;
        double averageOverallPerformanceComponents = 0;

        for (Peripheral peripheral : this.peripherals) {
            sumOverallPerformanceComponents += peripheral.getOverallPerformance();
        }

        averageOverallPerformanceComponents = sumOverallPerformanceComponents / this.components.size();

        return super.getOverallPerformance() + averageOverallPerformanceComponents;
    }

    @Override
    public double getPrice() {
        return super.getPrice() +
                this.components.stream().mapToDouble(c -> c.getPrice()).sum() +
                this.peripherals.stream().mapToDouble(p -> p.getPrice()).sum();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        boolean containsSuchComponent = false;
        for (Component componentChecked : this.components) {
            if (componentChecked.getClass().getSimpleName().equals(component.getClass().getSimpleName())) {
                containsSuchComponent = true;
                break;
            }
        }

        if (containsSuchComponent) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                    component.getClass().getSimpleName(),
                    this.getClass().getSimpleName(),
                    this.getId()));
        }

        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        int index = 0;
        boolean doesNotContainSuchComponent = true;
        for (int i = 0; i < this.components.size(); i++) {
            Component componentChecked = this.components.get(i);
            if (componentChecked.getClass().getSimpleName().equals(componentType)) {
                doesNotContainSuchComponent = false;
                index = i;
                break;
            }
        }

        if (this.components.isEmpty() || doesNotContainSuchComponent) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                    componentType,
                    this.getClass().getSimpleName(),
                    this.getId()));
        }

        return this.components.remove(index);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        boolean containsSuchPeripheral = false;
        for (Peripheral peripheralChecked : this.peripherals) {
            if (peripheralChecked.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())) {
                containsSuchPeripheral = true;
                break;
            }
        }

        if (containsSuchPeripheral) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(),
                    this.getClass().getSimpleName(),
                    this.getId()));
        }

        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        int index = 0;
        boolean doesNotContainSuchPeripheral = true;
        for (int i = 0; i < this.peripherals.size(); i++) {
            Peripheral peripheralChecked = this.peripherals.get(i);
            if (peripheralChecked.getClass().getSimpleName().equals(peripheralType)) {
                doesNotContainSuchPeripheral = false;
                index = i;
                break;
            }
        }

        if (this.peripherals.isEmpty() || doesNotContainSuchPeripheral) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                    peripheralType,
                    this.getClass().getSimpleName(),
                    this.getId()));
        }

        return this.peripherals.remove(index);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }
}
