package vn.edu.iuh.fit.nguyenducvinh_week05_www;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillType;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.JobSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
public class NguyenDucVinhWeek05WwwApplication implements CommandLineRunner {

    @Autowired
    private SkillRepository rs;

    @Autowired
    private AddressRepository ar;

    @Autowired
    private CandidateRepository cr;

    @Autowired
    private CompanyRepository comr;

    @Autowired
    private JobRepository jr;

//    @Autowired
//    private JobSkillRepository jkr;

    @Autowired
    private CandidateSkillRepository csk;

    public static void main(String[] args) {SpringApplication.run(NguyenDucVinhWeek05WwwApplication.class, args);}

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker();
        Random random = new Random();

//        List<Skill> skills = new ArrayList<>();
//////        // Thêm 20 dữ liệu vào danh sách
//        skills.add(new Skill("Java Development for Backend", "Java-Backend", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("Web development with JavaScript", "JavaScript", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("General-purpose programming language", "Python", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("JavaScript runtime for backend", "Node.js", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("Java framework for building web applications", "Spring Framework", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("Structured Query Language for database management", "SQL", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("Markup language and styling for websites", "HTML/CSS", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("JavaScript library for building user interfaces", "React.js", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("Web framework for building dynamic apps", "Angular", SkillType.TECHNICAL_SKILL));
//        skills.add(new Skill("Algorithm-based data analysis and prediction", "Machine Learning", SkillType.TECHNICAL_SKILL));
//
//        skills.add(new Skill("Managing teams and guiding others", "Leadership", SkillType.SOFT_SKILL));
//        skills.add(new Skill("Verbal and written communication skills", "Communication", SkillType.SOFT_SKILL));
//        skills.add(new Skill("Efficiently managing time and tasks", "Time Management", SkillType.SOFT_SKILL));
//        skills.add(new Skill("Identifying issues and finding solutions", "Problem Solving", SkillType.SOFT_SKILL));
//        skills.add(new Skill("Working well in teams and with others", "Collaboration", SkillType.SOFT_SKILL));
//        skills.add(new Skill("Generating new ideas and solutions", "Creativity", SkillType.SOFT_SKILL));
//        skills.add(new Skill("Adjusting to new situations and challenges", "Adaptability", SkillType.SOFT_SKILL));
//        skills.add(new Skill("Handling conflicts effectively", "Conflict Resolution", SkillType.SOFT_SKILL));
//
//        skills.add(new Skill("Managing and organizing projects and teams", "Project Management", SkillType.UNSPECIFIC));
//        skills.add(new Skill("Managing financial resources and budgets", "Financial Management", SkillType.UNSPECIFIC));
//        skills.add(new Skill("Planning and managing business growth", "Business Strategy", SkillType.UNSPECIFIC));
//
//        rs.saveAll(skills);
//
//        List<Address> addresses = new ArrayList<>();
//
//        // Thêm 20 địa chỉ mẫu
//        addresses.add(new Address("1st Avenue", "New York", (short) 1, "101", "10001"));
//        addresses.add(new Address("2nd Street", "Los Angeles", (short) 1, "202", "90001"));
//        addresses.add(new Address("3rd Boulevard", "Chicago", (short) 1, "303", "60601"));
//        addresses.add(new Address("4th Road", "Houston", (short) 1, "404", "77001"));
//        addresses.add(new Address("5th Drive", "Phoenix", (short) 1, "505", "85001"));
//        addresses.add(new Address("6th Lane", "Philadelphia", (short) 1, "606", "19019"));
//        addresses.add(new Address("7th Street", "San Antonio", (short) 1, "707", "78201"));
//        addresses.add(new Address("8th Avenue", "San Diego", (short) 1, "808", "92101"));
//        addresses.add(new Address("9th Court", "Dallas", (short) 1, "909", "75201"));
//        addresses.add(new Address("10th Place", "San Jose", (short) 1, "1010", "95101"));
//        addresses.add(new Address("11th Circle", "Austin", (short) 1, "1111", "73301"));
//        addresses.add(new Address("12th Plaza", "Jacksonville", (short) 1, "1212", "32099"));
//        addresses.add(new Address("13th Parkway", "Fort Worth", (short) 1, "1313", "76101"));
//        addresses.add(new Address("14th Terrace", "Columbus", (short) 1, "1414", "43201"));
//        addresses.add(new Address("15th Row", "San Francisco", (short) 1, "1515", "94101"));
//        addresses.add(new Address("16th Alley", "Charlotte", (short) 1, "1616", "28201"));
//        addresses.add(new Address("17th Trail", "Indianapolis", (short) 1, "1717", "46201"));
//        addresses.add(new Address("18th Square", "Seattle", (short) 1, "1818", "98101"));
//        addresses.add(new Address("19th Estate", "Denver", (short) 1, "1919", "80201"));
//        addresses.add(new Address("20th Gardens", "Washington", (short) 1, "2020", "20001"));
//
//        ar.saveAll(addresses);
//
//        // Tạo 100 ứng viên
//        for (int i = 0; i < 100; i++) {
//            // Tạo thông tin ứng viên
//            String fullName = faker.name().fullName();
//            String email = fullName.replaceAll(" ", ".").toLowerCase() + "@gmail.com";
//            String phone = faker.phoneNumber().phoneNumber();
//            String password = faker.internet().password();
//
//            // Tạo ngày sinh ngẫu nhiên trong khoảng 20-50 tuổi
//            LocalDate dob = LocalDate.now()
//                    .minusYears(20 + random.nextInt(31)); // 31 = 50 - 20 + 1
//
//            // Lấy địa chỉ ngẫu nhiên từ danh sách
//            Address address = addresses.get(random.nextInt(addresses.size()));
//
//            // Thêm ứng viên vào danh sách
////            candidates.add(new Candidate(dob, email, fullName, phone, password, address));
//            Candidate candidate = new Candidate(dob, email, fullName, phone, password, address);
//            cr.save(candidate);
//        }

//        List<Company> companies = new ArrayList<>();
//
//        // Tạo 20 công ty ngẫu nhiên
//        for (int i = 0; i < 19; i++) {
//            String compName = faker.company().name();
//            String email = faker.internet().emailAddress();
//            String phone = faker.phoneNumber().phoneNumber();
//            String about = faker.lorem().paragraph(3);  // Tạo mô tả công ty
//            String webUrl = faker.internet().url();
//
//            // Lấy một địa chỉ ngẫu nhiên
////            Address address = addresses.get(random.nextInt(addresses.size()));
//            Address address = ar.findById((long) i+1).get();
//            // Tạo đối tượng Company và thêm vào danh sách
////            companies.add(new Company(about, email, compName, phone, webUrl, address));
//            Company company = new Company(about, email, compName, phone, webUrl, address);
//            comr.save(company);
//        }

        // Tạo 100 Job
//        for (int i = 1; i <= 100; i++) {
//            // Lấy ngẫu nhiên một công ty từ ID 1 đến 20
//            Long companyId = (long) ((i % 20) + 1); // Luân phiên từ 1 đến 20
//            Optional<Company> companyOpt = comr.findById(companyId);
//
//            if (companyOpt.isPresent()) {
//                Company company = companyOpt.get();
//
//                // Tạo Job mới với dữ liệu từ Faker
//                Job job = new Job();
//                job.setJobName(faker.job().title());
//                job.setJobDesc(faker.lorem().sentence(15)); // Tạo mô tả ngẫu nhiên
//                job.setCompany(company);
//
//                // Lưu Job vào cơ sở dữ liệu
//                jr.save(job);
//            } else {
//                System.out.println("Company with ID " + companyId + " not found.");
//            }
//        }

//        for (int i = 0; i < 100; i++) { // Tạo 100 JobSkill ngẫu nhiên
//            long jobId = random.nextInt(95) + 1; // Random jobId từ 1 đến 95
//            long skillId = random.nextInt(43) + 1; // Random skillId từ 1 đến 43
//
//            Optional<Job> jobOpt = jr.findById(jobId);
//            Optional<Skill> skillOpt = rs.findById(skillId);
//
//            if (jobOpt.isPresent() && skillOpt.isPresent()) {
//                Job job = jobOpt.get();
//                Skill skill = skillOpt.get();
//
//                SkillLevel[] skillLevels = SkillLevel.values();
//                SkillLevel randomSkillLevel = skillLevels[random.nextInt(skillLevels.length)]; // Random SkillLevel
//
//                String moreInfos = "Kỹ năng " + skill.getSkillName() + " dành cho công việc " + job.getJobName();
//                JobSkillId jobSkillId = new JobSkillId(job.getId(), skill.getId());
//                // Tạo JobSkill và lưu vào DB
//                JobSkill jobSkill = new JobSkill(jobSkillId, "moreInfos", SkillLevel.BEGINER);
//                jkr.save(jobSkill);
//            } else {
//                System.out.println("Không tìm thấy Job hoặc Skill với ID: jobId=" + jobId + ", skillId=" + skillId);
//            }
//        }

//                for (int i = 0; i < 100; i++) { // Tạo 100 CandidateSkill ngẫu nhiên
//            long candidateId = random.nextInt(100) + 1; // Random jobId từ 1 đến 95
//            long skillId = random.nextInt(43) + 1; // Random skillId từ 1 đến 43
//
//            Optional<Candidate> camOpt = cr.findById(candidateId);
//            Optional<Skill> skillOpt = rs.findById(skillId);
//
//            if (camOpt.isPresent() && skillOpt.isPresent()) {
//                Candidate candidate = camOpt.get();
//                Skill skill = skillOpt.get();
//
//                CandidateSkillId candidateSkillId = new CandidateSkillId(candidate.getId(), skill.getId());
//                // Tạo JobSkill và lưu vào DB
//                CandidateSkill candidateSkill = new CandidateSkill(candidateSkillId, "moreInfos", SkillLevel.BEGINER);
//                csk.save(candidateSkill);
//            } else {
//                System.out.println("Không tìm thấy Job hoặc Skill với ID: jobId=" + candidateId + ", skillId=" + skillId);
//            }
//        }




    }
}
