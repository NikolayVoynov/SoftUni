package vaccopsjava;

import java.util.*;
import java.util.stream.Collectors;

public class VaccOps implements IVaccOps {
    //    Map<String, Doctor> doctorsMap;
//    Map<String, Patient> patientsMap;
    Map<Patient, Doctor> patientDoctorMap;
    Map<Doctor, List<Patient>> doctorsWithPatientsMap;

    public VaccOps() {
//        this.doctorsMap = new LinkedHashMap<>();
//        this.patientsMap = new LinkedHashMap<>();
        this.patientDoctorMap = new LinkedHashMap<>();
        this.doctorsWithPatientsMap = new LinkedHashMap<>();
    }

    public void addDoctor(Doctor d) {
        if (exist(d)) {
            throw new IllegalArgumentException();
        }

//        doctorsMap.put(d.name, d);
        doctorsWithPatientsMap.put(d, new ArrayList<>());
    }

    public void addPatient(Doctor d, Patient p) {
        if (!exist(d)) {
            throw new IllegalArgumentException();
        }

        doctorsWithPatientsMap.get(d).add(p);
        patientDoctorMap.put(p, d);
//        this.patientsMap.put(p.name, p);
    }

    public Collection<Doctor> getDoctors() {
        return this.doctorsWithPatientsMap.keySet();
    }

    public Collection<Patient> getPatients() {
        return this.patientDoctorMap.keySet();
    }

    public boolean exist(Doctor d) {
        return this.doctorsWithPatientsMap.containsKey(d);
    }

    public boolean exist(Patient p) {
        return this.patientDoctorMap.containsKey(p);
    }

    public Doctor removeDoctor(String name) {
        Doctor doctorRetire = null;
        for (Doctor doctor : doctorsWithPatientsMap.keySet()) {
            if (doctor.name.equals(name)) {
                doctorRetire = doctor;
                break;
            }
        }

        if (doctorRetire == null) {
            throw new IllegalArgumentException();
        }

        this.doctorsWithPatientsMap.remove(doctorRetire);

        return doctorRetire;
    }

    public void changeDoctor(Doctor from, Doctor to, Patient p) {
        if (!exist(from) || !exist(to) || !exist(p)) {
            throw new IllegalArgumentException();
        }

        this.doctorsWithPatientsMap.get(to).add(p);
        this.doctorsWithPatientsMap.get(from).remove(p);
    }

    public Collection<Doctor> getDoctorsByPopularity(int populariry) {
        return this.doctorsWithPatientsMap
                .keySet()
                .stream()
                .filter(doctor -> doctor.popularity == populariry)
                .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsByTown(String town) {
        return this.patientDoctorMap
                .keySet()
                .stream()
                .filter(patient -> patient.town.equals(town))
                .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsInAgeRange(int lo, int hi) {
        return this.patientDoctorMap
                .keySet()
                .stream()
                .filter(patient -> patient.age >= lo && patient.age <= hi)
                .collect(Collectors.toList());
    }

    public Collection<Doctor> getDoctorsSortedByPatientsCountDescAndNameAsc() {
        return this.doctorsWithPatientsMap
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    boolean isEqual = Integer.compare(f.getValue().size(), s.getValue().size()) == 0;

                    if (isEqual) {
                        return Integer.compare(f.getKey().name.length(), s.getKey().name.length());
                    }

                    return Integer.compare(f.getValue().size(), s.getValue().size());
                }).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge() {
        return this.patientDoctorMap
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    boolean equalPopularity = Integer.compare(f.getValue().popularity, s.getValue().popularity) == 0;

                    if (equalPopularity) {
                        boolean equalHeight = Integer.compare(s.getKey().height, f.getKey().height) == 0;

                        if (equalHeight) {
                            return Integer.compare(f.getKey().age, s.getKey().age);

                        }

                        return Integer.compare(s.getKey().height, f.getKey().height);
                    }

                    return Integer.compare(f.getValue().popularity, s.getValue().popularity);
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
