package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        for (Computer checkedComp : this.computers) {
            if (checkedComp.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
            }
        }

        Computer computer = null;
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }

        this.computers.add(computer);
        return String.format(OutputMessages.ADDED_COMPUTER, id);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computerCheck = this.computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        if (computerCheck == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        for (Component component : this.components) {
            if (component.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
            }
        }

        Component component = null;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }

        for (Computer computer : this.computers) {
            if (computer.getId() == computerId) {
                computer.addComponent(component);
            }
        }

        this.components.add(component);
        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {

        Computer computerCheck = this.computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        if (computerCheck == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        for (Computer computer : this.computers) {
            for (Component component : computer.getComponents()) {
                if (component.getClass().getSimpleName().equals(componentType)) {
                    computer.removeComponent(componentType);
                    break;
                }
            }
        }

        Component searchComponent = null;
        int componentId = 0;
        for (
                Component component : components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                componentId = component.getId();
                searchComponent = component;
                break;
            }
        }

        this.components.remove(searchComponent);

        return String.format(OutputMessages.REMOVED_COMPONENT, componentType, componentId);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computerCheck = this.computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        if (computerCheck == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        for (Peripheral peripheral : this.peripherals) {
            if (peripheral.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
            }
        }

        Peripheral peripheral = null;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }

        for (Computer computer : this.computers) {
            if (computer.getId() == computerId) {
                computer.addPeripheral(peripheral);
            }
        }

        this.peripherals.add(peripheral);
        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {

        Computer computerCheck = this.computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        if (computerCheck == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        for (Computer computer : this.computers) {
            for (Peripheral peripheral : computer.getPeripherals()) {
                if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                    computer.removePeripheral(peripheralType);
                    break;
                }
            }
        }

        Peripheral searchPeripheral = null;
        int peripheralId = 0;
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                peripheralId = peripheral.getId();
                searchPeripheral = peripheral;
                break;
            }
        }

        this.peripherals.remove(searchPeripheral);

        return String.format(OutputMessages.REMOVED_PERIPHERAL, peripheralType, peripheralId);
    }

    @Override
    public String buyComputer(int id) {
        Computer searchComputer = null;
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                searchComputer = computer;
            }
        }

        this.computers.remove(searchComputer);
        return searchComputer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        double highestOverall = 0;
        Computer foundComp = null;
        for (Computer computer : computers) {
            double current = computer.getOverallPerformance();
            if (current >= highestOverall) {
                highestOverall = current;
                foundComp = computer;
            }
        }

        if (foundComp.getPrice() > budget) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }

        this.computers.remove(foundComp);

        return foundComp.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = this.computers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        return computer.toString();
    }
}
