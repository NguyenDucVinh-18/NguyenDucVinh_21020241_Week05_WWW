# 21020241 - Nguyễn Đức Vinh
### LẬP TRÌNH WWW VỚI CÔNG NGHỆ JAVA

## ĐỀ TÀI
### LAB WEEK 5: TRANG WEB VIỆC LÀM

---

**GIÁO VIÊN HƯỚNG DẪN**: Võ Văn Hải  
**NGƯỜI THỰC HIỆN**: Nguyễn Đức Vinh  
**LỚP HỌC PHẦN**: DHKTPM17A - 420300362101

Thành phố Hồ Chí Minh, tháng 12 năm 2024

## I. Sơ đồ lớp
  ![Class diagram](https://i.ibb.co/ZSwD76N/class-Diagram.png)
## II. Các chức năng
### 1. Đối với ứng viên (candidate)
- **Đăng kí**
    - Chọn mục **Register for candidate** để thực hiện đăng kí đối với candidate
    ![login](https://i.ibb.co/rtxbRpc/login.png)
    - Màn hình đăng kí cho candidate
    ![registerCandidate](https://i.ibb.co/R3210sp/register-Candidate.png)
  
- **Đăng nhập**
    - Chọn đăng nhập với candidate
    - Nhập thông tin email và password vào màn hình đăng nhập
    - Nhấn **login Account**
  ![loginCandidate](https://i.ibb.co/0VL40YF/login-Candidate.png)
- **Màn hình chính candidate**
    - Hiển thị hồ sơ cá nhân của candidate
    - Hiển thị những job phù hợp với các kĩ năng mà candidate đang có
    ![homeCandidate](https://i.ibb.co/dp3BTbp/home-Candidate.png)
    - Candidate có thể chọn từng kĩ năng để tìm kiếm công việc cần kĩ năng đó đang đăng tuyển dụng
    ![homeCandidate2](https://i.ibb.co/2v7bLmZ/home-Candidate2.png)
- **Màn hình Detail**
  
    - Khi nhấn vào **Detail** trên từng công việc thì hiển thị thông tin chi tiết của công việc đang tuyển dụng
  ![detailJobCandidate](https://i.ibb.co/qMzrsjd/detail-Job-Candidate.png)
- **Màn hình thông tin chi tiết**
    - Khi nhấn vào chỉnh sửa hồ sơ chuyển sang trang profile với thông tin chi tiết của candidate
  ![candidateProfile](https://i.ibb.co/ZT2s9Bb/candidate-Profile.png)
### 2. Đối với công ty (company)
- **Đăng kí**
    - Chọn mục **Register for company** để thực hiện đăng kí đối với company
    ![login](https://i.ibb.co/rtxbRpc/login.png)
    - Màn hình đăng kí cho company
  ![registerCompany](https://i.ibb.co/DW92bxq/register-Company.png)
      
- **Đăng nhập**
    - Chọn đăng nhập với company
    - Nhập thông tin email và password vào màn hình đăng nhập
    - Nhấn **login Account**
  ![login-Company](https://i.ibb.co/j6sqqFj/login-Company.png)
- **Màn hình chính công ty**
    - Hiển thị thông tin chi tiết của công ty
    - Hiển thị tất cả các công việc mà công ty đã đăng tuyển dụng
    ![homeCompany](https://i.ibb.co/w0Ccdhc/home-Company.png)
  
- **Màn hình thêm công việc**
    - Khi nhấn vào **Add job** hiển thị màn hình thêm công việc cần tuyển dụng
      ![addJob](https://i.ibb.co/j6RgJYj/addJob.png)
- **Màn hình chi tiết công việc**
    - Khi nhấn vào **Detail** của mỗi công việc, hiển thị màn hình chi tiết của từng công việc
    - Trong này hiển thị tất cả những ứng viên có kĩ năng phù hợp với công việc yêu cầu
      ![detailJobCompany](https://i.ibb.co/qBq4gKM/detail-Job-Company.png)
