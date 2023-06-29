![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=header&text=블로그%20백엔드%20서버%20lv3&fontSize=50)

## 📝 블로그 백엔드 서버 만들기 Lv3
✍️ 개인과제 ✍️

## 📍 프로그램 요구사항
1. 회원 가입 API
  - username, password를 Client에서 전달받기
  - username은 최소 4자 이상 10자 이하이며 알파벳 소문자와 숫자로 구성
  - password는 최소 8자 이상 15자 이하이며 알파벳 대소문자와 숫자와 특수문자로 구성
  - DB에 중복된 username이 없다면 회원을 저장하고 Client로 성공했다는 메시지와 상태코드 반환
  - 회원 권한 부여하기 (ADMIN, USER) - ADMIN 회원은 모든 게시글과 댓글 수정 및 삭제 가능
2. 로그인 API
  - username, password를 Client에서 전달받기
  - DB에서 username을 사용해 저장된 회원의 유무를 확인하고, 있다면 password 비교
  - 로그인 성공 시, 로그인에 성공한 유저의 정보와 JWT를 활용해 토큰을 발급하고, 발급한 토큰을 Header에 추가한 후 성공했다는 메시지와 상태코드 Client에 반환
3. 댓글 작성 API
  - 토큰을 검사하여 유효한 토큰일 경우에만 댓글 작성 가능
  - 선택한 게시글의 DB 저장 유무 확인
  - 선택한 게시글이 있다면 댓글을 등록하고 등록된 댓글 반환
4. 댓글 수정 API
  - 토큰을 검사하여 유효한 토큰이면서 해당 사용자가 작성한 댓글만 수정 가능
  - 선택한 댓글의 DB 저장 유무를 확인
  - 선택한 댓글이 있다면 댓글을 수정하고 수정된 댓글 반환
5. 댓글 삭제 API
  - 토큰을 검사하여 유효한 토큰이면서 해당 사용자가 작성한 댓글만 삭제 가능
  - 선택한 댓글의 DB 저장 유무를 확인
  - 선택한 댓글이 있다면 댓글을 삭제하고 Client로 성공했다는 메시지와 상태코드 반환
6. 전체 게시글 목록을 조회하는 API
  - 제목, 작성자명(username), 작성 내용, 작성 날짜 조회
  - 작성 날짜를 기준으로 내림차순으로 정렬
7. 게시글을 작성하는 API
  - 토큰을 검사해 유효한 토큰일 경우에만 작성 가능
  - 제목, 작성 내용 저장
  - 저장된 게시글을 Client로 반환 (username은 로그인 된 사용자)
8. 선택한 게시글을 조회하는 API
  - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용 조회
  - 검색 기능이 아닌, 간단한 게시글 조회로 구현
9. 선택한 게시글을 수정하는 API
  - 토큰을 검사해 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능
  - 제목, 작성 내용을 수정하고 수정된 게시글을 Client로 반환
10. 선택한 게시글을 삭제하는 API
  - 토큰을 검사해 유효한 토큰이면서 해당 사용자가 작성한 게시글만 삭제 가능
  - 선택한 게시글을 삭제하고 Client로 성공했다는 메시지와 상태코드 반환
    
## 🔧 사용한 Tool
<img src="https://img.shields.io/badge/git-F05032?style=flat&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=flat&logo=github&logoColor=white">
<img src ="https://img.shields.io/badge/Java-007396?&style=flat&logo=Java&logoColor=white">
<img src="https://img.shields.io/badge/intellijidea-000000?style=flat&logo=intellijidea&logoColor=white">

## 🪶 API 명세서
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/f49cd639-7f7b-4793-b3e2-34a0d0278882"  width="800"/>
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/f37db9c5-fa8b-4cef-aec8-97d0cf3d79a7"  width="800"/>
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/6aceb613-fb0f-45d3-a520-cb5afdc3529a"  width="800"/>
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/f767ae2b-8c41-45e9-ad3c-d4b045de1a74"  width="800"/>

## 📜 테이블 구성
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/2bbc9326-4a7f-4ffa-a3ed-474d45208299"  width="800"/>
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/d382a458-600b-4b42-a1a1-ae5b4ab193ed"  width="800"/>
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/f2b93b93-250e-4c5b-bcf2-2bba621eb4e8"  width="800"/>

## 📃 ERD 설계
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/03645864-e236-4485-b930-98e1d9c620f0"  width="800"/>
<img src="https://github.com/azuressu/MyBlog_Comments/assets/74248726/f919bf7c-d796-4340-8560-a994a46a903e"  width="800"/>

## 🗂️ 파일 구성
1. controller 패키지 – CommentController.java, PostController.java, UserController.java
2. dto 패키지 – CommentRequestDto.java, CommentResponseDto.java, PostRequestDto.java, PostResponseDto.java, SignupRequestDto.java, StatusResponseDto.java, LoginRequestDto.java 
3. entity 패키지 – Comment.java, MyBlogErrorCode.java, Post.java, Timestapmed.java, User.java, UserRoleEnum.java
4. exception 패키지 - MyBlogException.java
5. jwt 패키지 – JwtUtil.java
6. repository 패키지 – PostRepository,java, UserRepository.java
7. security 패키지 – JwtAuthenticationFilter.java, JwtAuthorizationFilter.java, UserDetailsImpl.java, UserDetailsServiceImpl.java, WebSecurityConfig.java
8. service 패키지 – PostService.java, UserService.java

## 🪄 코드 구성
1. controller 패키지
   
1-1. CommentController.java
```java
@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 작성
    @PostMapping("/post/{id}/comment")
    public CommentResponseDto createComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.createComment(id, requestDto, userDetails.getUser());
    }

    // 댓글 수정
    @PutMapping("/post/{id}/comment/{commentid}")
    public CommentResponseDto updateComment(@PathVariable Long id, @PathVariable Long commentid, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletResponse res) {
        return commentService.updateCommnet(id, commentid, requestDto, userDetails.getUser(), res);
    }

    // 댓글 삭제
    @DeleteMapping("/post/{id}/comment/{commentid}")
    public StatusResponseDto deleteComment(@PathVariable Long id, @PathVariable Long commentid, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.deleteComment(id, commentid, userDetails.getUser());
    }
}
```
댓글에 대한 Controller 역할을 하는 클래스이다. 기능별로 url과 메소드를 각각 매핑하여 작성했다.
토큰으로부터 사용자의 정보를 받아와야 하므로 댓글 작성, 수정, 삭제에는 @AuthenticationPrincipal 에너테이션을 사용했다. 

1-2. PostController.java
```java
@RestController // ResponseBody는 붙이면 안됨 !
@RequestMapping("/api")
public class PostController {

    // 제어의 흐름 : PostController → PostService → PostRepository
    private final PostService postService;

    public PostController(PostService postService) { this.postService = postService; }

    // 게시글 작성
    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.createPost(requestDto, userDetails.getUser());
    }

    // 전체 게시글 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    // 선택 게시글 조회
    @GetMapping("/post/{id}")
    public PostResponseDto getOnePost(@PathVariable Long id) {
        return postService.getOnePost(id);
    }

    // 게시글 수정
    @PutMapping("/post/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto,
                                      @AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletResponse res) {
        return postService.updatePost(id, requestDto, userDetails.getUser(), res);
    }

    // 게시글 삭제
    @DeleteMapping("/post/{id}")
    public StatusResponseDto deletePost(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.deletePost(id, userDetails.getUser());
    }
}
```
게시글에 대한 Controller 역할을 하는 클래스이다.
기능별로 url과 메소드를 각각 매핑하여 작성했다.
토큰으로부터 사용자의 정보를 받아와야 하므로 게시글 작성, 수정, 삭제에는 @AuthenticationPrincipal 에너테이션을 사용했다.

1-3. UserController.java
```java
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    // 회원가입
    @PostMapping("/user/signup")
    public StatusResponseDto signup(HttpServletResponse res, @Valid @RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(res, signupRequestDto);
    }
}
```
사용자에 대한 Controller 역할을 하는 클래스이다.
회원가입을 진행할 url와 메소드를 작성했다.

2. dto 패키지
   
2-1. CommentRequestDto.java
```java
@Getter
public class CommentRequestDto {
    String commentcontents;      // 댓글 내용
}
```
댓글의 내용을 받아오기 위한 requestDto 클래스이다.

2-2. CommentResponsDto.java
```java
@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private Long id;                      // 댓글 id
    private String username;             // 댓글 작성자
    private String commentcontents;     // 댓글 내용
    private LocalDateTime createTime;   // 댓글 작성일
    private LocalDateTime modifyTime;   // 댓글 수정일

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getUser().getUsername();
        this.commentcontents = comment.getCommentcontents();
        this.createTime = comment.getCreateTime();
        this.modifyTime = comment.getModifyTime();
    }
}
```
댓글의 내용을 보여주기 위한 responseDto 클래스이다.
댓글의 id와 댓글 작성자 이름, 댓글의 내용, 댓글의 작성일과 수정일을 보여준다.

2-3. LoginRequestDto.java
```java
@Getter
@Setter
public class LoginRequestDto {
    @NotBlank
    private String username;  // 사용자 이름
    @NotBlank
    private String password;   // 사용자 비밀번호
}
```
로그인을 할 때, 사용자 이름과 비밀번호를 입력받기 위한 requestDto 클래스이다.

2-4. PostRequestDto.java 
```java
@Getter
public class PostRequestDto {
    private String title;      // 게시글 제목
    private String contents; // 게시글 내용
}
```
게시글을 작성할 때, 게시글의 제목과 내용을 입력받기 위한 requestDto 클래스이다.

2-5. PostResponseDto.java
```java
@Getter
public class PostResponseDto {

    private Long id;                    // 게시글 번호
    private String username;           // 사용자 이름
    private String contents;            // 게시글 내용
    private String title;                 // 게시글 제목
    private LocalDateTime createTime;  // 게시글 작성일
    private LocalDateTime modifyTime; // 게시글 수정일
    private List<CommentResponseDto> commentList = new ArrayList<>(); // 댓글 리스트

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getUser().getUsername();
        this.contents = post.getContents();
        this.createTime = post.getCreateTime();
        this.modifyTime = post.getModifyTime();
	// post의 댓글 리스트 사이즈가 0보다 크다면
	if (post.getCommentList().size() > 0) {
            for (Comment comment : post.getCommentList()) {  // 
                this.commentList.add(new CommentResponseDto(comment));
            }
        }
    }
}
```
게시글에 대한 정보를 사용자에게 보내주기 위한 responseDto 클래스이다.
게시글 번호, 사용자 이름, 게시글의 제목과 내용, 게시글의 작성일과 수정일에 대한 정보를 담고 있다.
post에 있는 commentlist를 CommentResponseDto 타입으로 하나씩 담아준다.

2-6. SignupRequestDto.java
```java
@Getter
@Setter
public class SignupRequestDto {
    @NotBlank
    @Size(min = 4, max = 10)
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "알파벳 소문자와 숫자만 입력 가능합니다")
    private String username;       // 사용자 이름

    @NotBlank
    @Size(min = 8, max = 15, message = "8자에서 15자로 입력해야 합니다")
    @Pattern(regexp = "^[A-Za-z0-9@$!%*?&]*$", message = "알파벳 대소문자와 숫자, 특수문자만 입력 가능합니다") 
    private String password;        // 사용자 비밀번호

    private boolean admin = false;  // ADMIN 여부
    private String adminToken = ""; // ADMIN 토큰 여부
}
```
회원가입을 할 때 사용자의 이름과 비밀번호를 입력받기 위한 requestDto 클래스이다.
사용자의 이름은 최소 4자에서 10자, 알파벳 소문자와 숫자만 입력받을 수 있다.
사용자의 비밀번호는 최소 8자에서 15자이며, 알파벳 대소문자와 숫자와 특수문자만 입력받을 수 있다.
또한 admin으로 회원가입하고 싶은 경우, admin 토큰도 입력해주어야 한다.

2-7. StatusResponseDto.java
```java
@Getter
@Setter
public class StatusResponseDto {
    String msg;
    Integer statusCode;
}
```
사용자에게 메시지와 상태코드를 반환하기 위한 responseDto 클래스이다.

3. entity 패키지
   
3-1. Comment.java
```java
@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값 자동 증가
    private Long id;                     // 댓글 id
    @Column(name = "commentcontents", nullable = false)
    private String commentcontents;    // 댓글 내용

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;                   // 사용자

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;                    // 게시글

    public Comment(CommentRequestDto commentRequestDto) {
        this.commentcontents = commentRequestDto.getCommentcontents();
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.commentcontents = commentRequestDto.getCommentcontents();
    }

}
```
댓글을 저장하기 위한 Entity 클래스이다.
댓글의 id와 댓글의 내용, 사용자의 정보와 게시글의 정보를 함께 저장한다.
댓글과 사용자는 다대일, 댓글과 게시글은 다대일의 관계를 갖는다.
또한 수정한 댓글의 내용을 저장할 수 있는 update 메소드도 존재한다.

3-2. MyBlogErrorCode.java
```java
@Getter
public enum MyBlogErrorCode {

    INVALID_TOKEN(400, "토큰이 유효하지 않습니다."),
    UNAUTHORIZED_USER(400, "작성자만 수정/삭제할 수 있습니다."),
    IN_USED_USERNAME(400, "중복된 username 입니다."),
    WRONG_ADMIN_TOKEN(400, "관리자 암호가 틀려 등록이 불가능합니다."),
    NOT_FOUND_USER(400, "회원을 찾을 수 없습니다."),
    NOT_FOUNT_POST(400, "요청한 게시글을 찾을 수 없습니다."),
    WRONG_PASSWORD(400, "비밀번호가 틀렸습니다."),
    NOT_FOUND_COMMENT(400, "작성한 댓글을 찾을 수 없습니다");

    private int errorCode;
    private String errorMessage;

    MyBlogErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
```
errorCode에 대한 상태코드와 메시지를 저장하기 위한 enum이다.

3-3. Post.java
```java
@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // auto_increase
    private Long id;              // 게시글 id
    @Column(name = "title", nullable = false)
    private String title;           // 게시글 제목
    @Column(name = "contents", nullable = false)
    private String contents;       // 게시글 내용

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;            // 사용자

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Comment> commentList = new ArrayList<>();  // 댓글 리스트

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto requestDto) {
        // 제목, 작성 내용을 수정
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
```
Post 엔티티를 저장하기 위한 클래스이다.
id는 자동으로 증가되도록 설정하고, 제목과 내용을 입력받으며 user 테이블과 다대일로 관계를 가지고 있다.
또한 comment 테이블과 일대다의 관계를 가지고 있고, 게시글에 대한 수정내용을 반영하기 위한 update 메소드도 존재한다.

3-4. Timestapmed.java
```java
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {

    @CreatedDate
    @Column(updatable = false)        // 이후에는 값이 수정되지 않음
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createTime;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifyTime;
}
```
게시글이나 댓글의 게시일과 수정일을 지정하기 위한 추상 클래스이다.

3-5. User.java
```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;         // 사용자 이름

    @Column(name = "password", nullable = false)
    private String password;          // 비밀번호

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(String username, String password , UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
```
사용자에 대한 Entity 클래스이다.
사용자의 이름과 비밀번호, 역할을 저장하고, post 테이블과 일대다 관계를 맺고 있다.
사용자에 대한 역할을 저장하는 필드도 존재한다.

3-6. UserRoleEnum.java
```java
public enum UserRoleEnum {
    USER(Authority.USER), // 사용자 권한
    ADMIN(Authority.ADMIN);  // 관리자 권한

    private final String authority;
    UserRoleEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}
```
사용자의 역할을 저장하기 위한 클래스이다.
회원가입 시 adminToken 여부에 따라 권한을 ADMIN으로 할 수도, USER로 할 수도 있다.

4. exception 패키지
   
4-1. MyBlogException.java
```java
@ResponseStatus(value = HttpStatus.BAD_REQUEST)        // response로 들어가는 에러 코드를 400으로 통일
public class MyBlogException extends RuntimeException{   // 실행 중에 발생한 예외

    private final MyBlogErrorCode errorCode;

    public MyBlogException(MyBlogErrorCode errorCode, Throwable cause) {
        super(errorCode.getErrorMessage(), cause, false, false);
        this.errorCode = errorCode;
    }

    public MyBlogErrorCode getErrorCode() { return this.errorCode; }
}
```
실행 중 발생한 400 에러의 경우 클래스이다. errorCode와 메시지를 갖고 있다.

5. jwt 패키지
   
5-1. JwtUtil.java
```java
@Slf4j(topic = "JwtUtil")
@Component // Bean으로 등록할 에너테이션
public class JwtUtil {

    // Header Key 값
    public static final String AUTHORIZATION_HEADER = "Authorization";
    // 사용자 권한 값의 Key
    public static final String AUTHORIZAION_KEY = "auth";
    // Token 식별자
    public static final String BEARER_PREFIX = "Bearer ";
    // Token 만료 시간
    public final Long TOKEN_TIME = 60 * 60 * 1000L; // 60분

    @Value("${jwt.secret.key}")
    private String secretKey;
    private Key key;
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @PostConstruct
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);
        key = Keys.hmacShaKeyFor(bytes);
    }

    // Token 생성
    public String createToken(String username, UserRoleEnum role) {
        Date date = new Date();

        return BEARER_PREFIX +
                Jwts.builder()
                        .setSubject(username) // 사용자 식별자값 (사용자 이름)
                        .claim(AUTHORIZAION_KEY, role) // 사용자 권한
                        .setExpiration(new Date(date.getTime() + TOKEN_TIME)) // 토큰 만료 시간
                        .setIssuedAt(date) // 발급일
                        .signWith(key, signatureAlgorithm) // 암호화 알고리즘
                        .compact();
    } // createToken()

    // Header에서 JWT 가져오기
    public String getJwtFromHeader(HttpServletRequest request) {
        // Header에서 토큰 뽑기
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        // 토큰이 null이 아니면서 비어있지 않고, Bearer로 시작하는지 확인 후
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            // 7번째 부터 잘라서 가져오기
            return bearerToken.substring(7);
        }
        return null;
    }

    // Token 검증
    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException | SignatureException e) {
            log.error("Token 검증 실패");
            log.error("Invalid JWT signature, 유효하지 않은 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.error("Token 검증 실패");
            log.error("Expired JWT token, 만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.error("Token 검증 실패");
            log.error("Unsupported JWT token, 지원되지 않은 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.error("Token 검증 실패");
            log.error("JWT claims is empty, 잘못된 JWT 토큰입니다.");
        }
        return false;
    }

    // Token 에서 사용자 정보 가져오기
    public Claims getUserInfoFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    // 상태 코드 반환하기
    public void status(int statusCode, String message, HttpServletResponse response) throws IOException {
        // 응답 데이터를 JSON 형식으로 생성
        String jsonResponse = "{\"status\": " + statusCode + ", \"message\": \"" + message + "\"}";

        // Content-Type 및 문자 인코딩 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // PrintWriter를 사용하여 응답 데이터 전송
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
    }
}
```
Jwt 토큰에 대한 기능이 담긴 클래스이다.
사용자의 이름과 역할로 token을 생성하고, header에서 토큰을 가져오고, 토큰을 검증하고, 토큰에서 사용자의 정보를 가져오는 메소드가 존재한다.
또한 상태 코드를 반환하기 위한 메소드인 status()도 존재한다.

6. repository 패키지
   
6-1. CommentRepository.java
```java
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostIdOrderByCreateTimeDesc(Long postid);
}
```
댓글에 대한 Repository 인터페이스이다.
postid로 찾고, 게시일 내림차순으로 정렬하기 위한 메소드가 있다.

6-2. PostRepository.java
```java
public interface PostRepository extends JpaRepository<Post, Long> {
    // 모든 메모들을 생성한 시간을 기준으로 정렬
    List<Post> findAllByOrderByCreateTimeDesc();
}
```
게시글에 대한 Repository 인터페이스이다.
메모들을 생성 시간을 기준으로 정렬하기 위한 메소드가 있다.

6-3. UserRepository.java
```java
public interface UserRepository extends JpaRepository<User, String> { 
    // PK 값이 Username이기 때문
    Optional<User> findByUsername(String username);
}
```
사용자에 대한 Repository 인터페이스이다.
사용자의 이름으로 사용자를 찾기 위한 메소드가 있다.

7. security 패키지
   
7-1. JwtAuthenticationFilter.java
```java
@Slf4j(topic = "로그인 및 JWT 생성")
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        setFilterProcessesUrl("/api/user/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals(HttpMethod.POST.name())) { // POST가 아닌 메소드는 걸러내기
            try {
                status(400, "Http Method Error", response);
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            // LoginRequestDto 사용
            LoginRequestDto requestDto = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDto.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestDto.getUsername(),
                            requestDto.getPassword()
                            ,null
                    )
            );
        } catch (IOException e) {
            try {
                status(400, "회원을 찾을 수 없습니다.", response);
                log.error("회원을 찾을 수 없습니다.");
                return null;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    } // attemptAuthentication()

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        log.info("로그인 성공 및 jwt 생성");
        String username = ((UserDetailsImpl) authResult.getPrincipal()).getUsername();
        UserRoleEnum role = ((UserDetailsImpl) authResult.getPrincipal()).getUser().getRole();

        String token = jwtUtil.createToken(username, role);
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, token);

        status(200, "로그인 성공", response);
    }

    @Override
    public void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setStatus(400);
        status(400, "회원을 찾을 수 없습니다.", response);
        log.error("400, 회원을 찾을 수 없습니다.");
    }

    // 상태 코드 반환하기
    public void status(int statusCode, String message, HttpServletResponse response) throws IOException {
        // 응답 데이터를 JSON 형식으로 생성
        String jsonResponse = "{\"status\": " + statusCode + ", \"message\": \"" + message + "\"}";

        // Content-Type 및 문자 인코딩 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // PrintWriter를 사용하여 응답 데이터 전송
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
    }
}
```
로그인 시 JWT를 생성하여 반환해주는 Filter 클래스이다.
LoninRequestDto를 통해서 사용자의 정보를 받아오고, 일치하는 경우 토큰을 생성하여 response header에 담아준다.
상태 코드를 반환하기 위한 status() 메소드도 존재한다.

7-2. JwtAuthorizationFilter.java
```java
@Slf4j(topic = "JWT 검증 및 인가")
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtAuthorizationFilter(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String tokenValue = jwtUtil.getJwtFromHeader(req); // 상태코드 반환을 위해서 res 추가

        if (StringUtils.hasText(tokenValue) && !req.getMethod().equals("GET")) {

            if (!jwtUtil.validateToken(tokenValue)) {
                log.error("Token Error: HttpServletRequest Header의 토큰이 유효하지 않습니다.");
                status(400, "유효하지 않은 토큰입니다", res);
                return;
            }

            Claims info = jwtUtil.getUserInfoFromToken(tokenValue);

            try {
                setAuthentication(info.getSubject());
            } catch (Exception e) {
                log.error(e.getMessage());
                return;
            }
        }

        filterChain.doFilter(req, res);
    } // doFilterInternal

    // 인증 처리
    public void setAuthentication(String username) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication = createAuthentication(username);

        context.setAuthentication(authentication);

        SecurityContextHolder.setContext(context);
    } // setAuthentication

    // 인증 객체 생성
    public Authentication createAuthentication(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // return 타입이 Authentication 임
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    } // createAuthentication()

    // 상태 코드 반환하기
    public void status(int statusCode, String message, HttpServletResponse response) throws IOException {
        // 응답 데이터를 JSON 형식으로 생성
        String jsonResponse = "{\"statusCode\": " + statusCode + ", \"message\": \"" + message + "\"}";

        // Content-Type 및 문자 인코딩 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // PrintWriter를 사용하여 응답 데이터 전송
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
    }
}
```
JWT를 검증하고 인가하기 위한 Filter 클래스이다.
Header로부터 얻은 토큰이 비어있는지, 유효한지 검증한 후 올바르다면 인증 객체를 생성한다.
상태 코드를 반환하기 위한 status() 메소드도 존재한다.

7-3. UserDetailsImpl.java
```java
public class UserDetailsImpl implements UserDetails {

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserRoleEnum role = user.getRole();
        String authority = role.getAuthority();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
```
UserDetails를 implements 받는 UserDetailsImpl 클래스이다.
사용자에 대한 정보를 갖고 있다.

7-4. UserDetailsServiceImpl.java
```java
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found " + username));

        return new UserDetailsImpl(user);
    }
}
```
UserDetailsService를 implements 받고 있는 UserDetailsServiceImpl 클래스이다.
loadUserByUsername() 메소드를 오버라이드 하여 사용한다.
username으로 UserRepository에서 사용자를 찾아서 UserDetailsImpl 객체를 생성해 반환한다.

7-5. WebSecurityConfig.java
```java
@Configuration
@EnableWebSecurity // Spring Security 자원 사용을 가능하게 하는 에너테이션
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(jwtUtil);
        filter.setAuthenticationManager(authenticationManager(authenticationConfiguration));
        return filter;
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() {
        // return 인증
        return new JwtAuthorizationFilter(jwtUtil, userDetailsService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // CSRF 설정
        http.csrf((csrf) -> csrf.disable());

        // 기본 설정인 Session 방식은 사용하지 않고 JWT 방식을 사용하기 위한 설정
        http.sessionManagement((sessionManagement)
                -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // resources 접근 허용 설정
                        .requestMatchers("/").permitAll() // 메인 페이지 요청
                        .requestMatchers("/api/user/**").permitAll() // 'api/user/'로 시작하는 요청 모두 접근 허가
                        .requestMatchers("/api/posts").permitAll() // api/posts 만 허용
                        .requestMatchers(HttpMethod.GET,"/api/post/**").permitAll() // 해당 url의 get 요청만 허용
                        .anyRequest().authenticated() // 그 외 모든 요청 인증처리
        );

        // form 로그인 사용하지 않음
        http.formLogin((formLogin) -> formLogin.disable());

        // 필터 관리
        http.addFilterBefore(jwtAuthorizationFilter(), JwtAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
```
Spring Security를 사용하는 클래스이다.
resources에 대한 접근 여부와, 지정하는 url에 대한 요청 접근 등을 제어하고 필터의 순서를 관리한다.

8. service 패키지
   
8-1. CommentService.java
```java
@Slf4j
@Service
public class CommentService {
    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CommentRepository commentRepository;

    public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    // 댓글 작성
    public CommentResponseDto createComment(Long id, CommentRequestDto requestDto, User user) {
        Post post = findPost(id);

        // 작성한 댓글
        Comment comment = new Comment(requestDto);
        comment.setUser(user);
        comment.setPost(post);
        commentRepository.save(comment);

        // 게시글의 댓글 리스트에 댓글 추가하기
        post.addComment(comment);

        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
        return commentResponseDto;
    }

    // 댓글 수정
    @Transactional
    public CommentResponseDto updateCommnet(Long id, Long commentid, CommentRequestDto requestDto, User user, HttpServletResponse res) {
        // 해당 게시글이 있는지 확인
        findPost(id);
        // 해당 댓글이 있는지 확인
        Comment comment = findComment(commentid);
        // 해당 댓글을 작성한 작성자 이거나, 권한이 ADMIN인 경우 댓글 수정 가능
        if (comment.getUser().getUsername().equals(user.getUsername())
                || user.getRole().getAuthority().equals("ROLE_ADMIN")) {
            // 있으면 댓글 내용 업데이트
            comment.update(requestDto);
            // ResponseDto에 내용 담아서 반환
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            return commentResponseDto;
        } else {
            try {
                status(400, "작성자만 삭제/수정할 수 있습니다.", res);
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } // else
    }

    // 댓글 삭제
    public StatusResponseDto deleteComment(Long id, Long commentid, User user) {
        // 해당 게시글이 있는지 확인
        findPost(id);
        // 해당 댓글이 있는지 확인
        Comment comment = findComment(commentid);
        // 해당 댓글을 작성한 작성자 이거나, 권한이 ADMIN인 경우 댓글 삭제 가능
        if (comment.getUser().getUsername().equals(user.getUsername())
                || user.getRole().getAuthority().equals("ROLE_ADMIN")) {
            // 있으면 댓글 삭제
            commentRepository.delete(comment);
            // 상태 ResponseDto에 담아서 반환
            StatusResponseDto statusResponseDto = new StatusResponseDto();
            statusResponseDto.setMessage("댓글 삭제 성공");
            statusResponseDto.setStatusCode(200);
            return statusResponseDto;
        } else {
            StatusResponseDto statusResponseDto = new StatusResponseDto();
            statusResponseDto.setMessage("작성자만 삭제/수정할 수 있습니다.");
            statusResponseDto.setStatusCode(400);
            return statusResponseDto;
        }
    }

    // 해당 포스트를 찾아서 반환
    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다."));
    }
    // 해당 댓글을 찾아서 반환
    private Comment findComment(Long commentid) {
        return commentRepository.findById(commentid).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다"));
    }

    // 상태 코드 반환하기
    public void status(int statusCode, String message, HttpServletResponse response) throws IOException {
        // 응답 데이터를 JSON 형식으로 생성
        String jsonResponse = "{\"statusCode\": " + statusCode + ", \"message\": \"" + message + "\"}";

        // Content-Type 및 문자 인코딩 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // PrintWriter를 사용하여 응답 데이터 전송
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
    }
}
```
댓글에 대한 Service 클래스이다.
댓글을 작성하는 메소드는 사용자의 정보를 받아와 해당 댓글에 사용자를 넣어준다.
댓글을 수정하고, 삭제하는 메소드에는 사용자의 정보를 받아와 게시글의 작성자인지 확인하여 수정/삭제를 진행한다.
ADMIN인 경우, 작성자가 아니어도 수정 및 삭제가 가능하다.
게시글 id를 받아와서 postRepository에서 해당 게시글이 있는지 찾는 메소드와 댓글 id를 받아와서 commentRepository에서 해당 댓글이 있는지 찾는 메소드가 있다.

8-2. PostService.java
```java
@Slf4j
@Service
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    // 게시글 생성
    public PostResponseDto createPost(PostRequestDto requestDto, User user) {
        Post post = new Post();
        post.setUser(user);
        post.setTitle(requestDto.getTitle());
        post.setContents(requestDto.getContents());

        // DB에 저장
        Post savePost = postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(savePost);
        return postResponseDto;
    }

    // 게시글 목록 조회
    public List<PostResponseDto> getPosts() {
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        List<Post> postList = postRepository.findAllByOrderByCreateTimeDesc();

        for (Post post: postList) {
            post.setCommentList(commentRepository.findAllByPostIdOrderByCreateTimeDesc(post.getId()));
            postResponseDtoList.add(new PostResponseDto(post));
        }
        return postResponseDtoList;
    }

    // 선택 게시글 조회
    public PostResponseDto getOnePost(Long id) {
        Post post = findPost(id);
        post.setCommentList(commentRepository.findAllByPostIdOrderByCreateTimeDesc(post.getId()));
        return new PostResponseDto(post);
    }

    // 게시글 수정
    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto, User user, HttpServletResponse res){
        Post post = findPost(id);
        // 해당 게시글을 작성한 작성자 이거나, 권한이 ADMIN인 경우는 삭제 가능
        if (post.getUser().getUsername().equals(user.getUsername())
                || user.getRole().getAuthority().equals("ROLE_ADMIN")) {
            post.update(requestDto);
            PostResponseDto postResponseDto = new PostResponseDto(post);
            return postResponseDto;
        } else {
            try {
                log.error("게시글 작성자만 수정할 수 있습니다.");
                status(400, "작성자만 삭제/수정할 수 있습니다.", res);
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 게시글 삭제
    public StatusResponseDto deletePost(Long id, User user) {
        Post post = findPost(id);
        // 해당 게시글을 작성한 작성자 이거나, 권한이 ADMIN인 경우는 삭제 가능
        if (user.getUsername().equals(post.getUser().getUsername())
                || user.getRole().getAuthority().equals("ROLE_ADMIN")) {
            postRepository.delete(post);

            StatusResponseDto statusResponseDto = new StatusResponseDto();
            statusResponseDto.setMessage("게시글 삭제 성공");
            statusResponseDto.setStatusCode(200);
            return statusResponseDto;
        } else {
            StatusResponseDto statusResponseDto = new StatusResponseDto();
            log.error("게시글 작성자만 수정할 수 있습니다.");
            statusResponseDto.setMessage("작성자만 삭제/수정할 수 있습니다.");
            statusResponseDto.setStatusCode(400);
            return statusResponseDto;
        }
    }

    // 해당 포스트를 찾아서 반환
    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다."));
    }

    // 상태 코드 반환하기
    public void status(int statusCode, String message, HttpServletResponse response) throws IOException {
        // 응답 데이터를 JSON 형식으로 생성
        String jsonResponse = "{\"statusCode\": " + statusCode + ", \"message\": \"" + message + "\"}";

        // Content-Type 및 문자 인코딩 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // PrintWriter를 사용하여 응답 데이터 전송
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
    }

}
```
게시글에 대한 Service 클래스이다.
게시글 전체조회와 선택 게시글 조회는 각각 PostResponseDto에 담아 반환한다.
게시글을 작성하는 메소드는 사용자의 정보를 받아와 해당 게시글에 사용자를 넣어준다.
게시글을 수정하고, 삭제하는 메소드에는 사용자의 정보를 받아와 게시글의 작성자인지 확인하여 수정/삭제를 진행한다.
ADMIN의 경우, 작성자가 아니어도 게시글을 수정 및 삭제할 수 있다.
게시글 id를 받아와서 postRepository에서 해당 게시글이 있는지 찾는 메소드가 있다.

8-3. UserService.java
```java
@Slf4j
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ADMIN_TOKEN
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    // 회원가입
    public StatusResponseDto signup(HttpServletResponse res, SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        log.info(username);

        String password = passwordEncoder.encode(requestDto.getPassword());

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            try {
                status(400, "중복된 username 입니다.", res);
                log.error("중복된 username 입니다.");
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (!requestDto.getAdminToken().isBlank()) {
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken())) {
                throw new MyBlogException(MyBlogErrorCode.WRONG_ADMIN_TOKEN, null);
            }
            // 수동으로 admin의 값을 true로 설정해줌
            requestDto.setAdmin(true);
            role = UserRoleEnum.ADMIN;
        }

        // 사용자 등록
        User user = new User(username, password, role);
        userRepository.save(user);

        StatusResponseDto statusResponseDto = new StatusResponseDto();
        statusResponseDto.setMessage("회원가입 성공");
        statusResponseDto.setStatusCode(200);

        return statusResponseDto;
    }

    // 상태 코드 반환하기
    public void status(int statusCode, String message, HttpServletResponse response) throws IOException {
        // 응답 데이터를 JSON 형식으로 생성
        String jsonResponse = "{\"status\": " + statusCode + ", \"message\": \"" + message + "\"}";

        // Content-Type 및 문자 인코딩 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // PrintWriter를 사용하여 응답 데이터 전송
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse);
        writer.flush();
    }
}
```
사용자에 대한 Service 클래스이다.
회원가입을 진행하며, userRepository에 중복되는 username이 있는지 확인하고,
입력받은 adminToken이 있다면 일치 여부를 확인 한 뒤 사용자를 등록한다.

![Footer](https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=footer)
