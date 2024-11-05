package com.pool.customer.serviceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.customer.dto.AttachmentDto;
import com.pool.customer.dto.LoginDto;
import com.pool.customer.dto.LoginResponseDto;
import com.pool.customer.dto.RoleDto;
import com.pool.customer.dto.UserDto;
import com.pool.customer.entity.Attachment;
import com.pool.customer.entity.Role;
import com.pool.customer.entity.User;
import com.pool.customer.repository.AttachmentRepository;
import com.pool.customer.repository.RoleRepository;
import com.pool.customer.repository.UserRepository;
import com.pool.customer.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

@Service
@Transactional
@Configurable
public class UserServiceImpl implements UserService {
    @Autowired
	private UserRepository userRepository;
    
    @Autowired
	private RoleRepository roleRepository;
    
    @Autowired
	private AttachmentRepository attachmentRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Autowired
    private HttpServletResponse response;
    
	@Override
	@CachePut(cacheNames = "user", key = "#dto.id")
	public UserDto save(UserDto dto) {
		User obj = new User();
		if (dto.getId() == 0) {
			String hashPassword = passwordEncoder.encode(dto.getPassword());
			obj.setPassword(hashPassword);
		}
		obj.setId(dto.getId());
		obj.setFirstName(dto.getFirstName());
		obj.setLastName(dto.getLastName());
		obj.setActive(true);
		obj.setCreationDate(LocalDateTime.now());
		obj.setDeleted(false);
		obj.setEmail(dto.getEmail());
		obj.setGender(dto.getGender());
		obj.setPhoneNumber(dto.getPhoneNumber());
		obj.setUpdationDate(LocalDateTime.now());		
		Role role = roleRepository.findById(dto.getRoleId()).orElseThrow(() -> new RuntimeException("Role is  necessary"));
		obj.setRole(role);		
		Attachment atch = attachmentRepository.findById(dto.getAttachmentId()).orElse(null);
		obj.setAttachment(atch);
		User savedData = userRepository.save(obj);	
		System.out.println("record saved and updated");
		return mapUserDto(savedData);
	}
	
	private UserDto mapUserDto(User usr) {
		UserDto dto = new UserDto();
		dto.setId(usr.getId());
		dto.setLastName(usr.getLastName());
		dto.setFirstName(usr.getFirstName());
		dto.setEmail(usr.getEmail());
		dto.setGender(usr.getGender());
		dto.setPhoneNumber(dto.getPhoneNumber());
		if (usr.getRole() != null) {
			RoleDto roleDto = new RoleDto();
			roleDto.setId(usr.getRole().getId());
			roleDto.setName(usr.getRole().getName());
			dto.setRole(roleDto);
		}
		if (usr.getAttachment() != null) {
			AttachmentDto aDto = new AttachmentDto();
			aDto.setId(usr.getAttachment().getId());
			aDto.setFile(usr.getAttachment().getFile());
			aDto.setFileName(usr.getAttachment().getFileName());
			aDto.setFileType(usr.getAttachment().getFileType());
			dto.setAttachment(aDto);
		}
		return dto;
	}

	@Override
	public UserDto update(UserDto dto) {
 		return save(dto);
	}

	@Override
	@Cacheable(cacheNames = "user", key = "#id")
	public UserDto getUser(long id) {
		User user = userRepository.findById(id).orElse(null);
		System.out.println("record gettt");
        redisTemplate.opsForValue().set("token:Email" + user.getEmail(), user.getFirstName(), Duration.ofMinutes(2));
        String tokenString = redisTemplate.opsForValue().get("token:Email" + user.getEmail());
        System.out.println("token++++++++++---->>>" + tokenString);
		return mapUserDto(user);
	}

	@Override
	public LoginResponseDto login(LoginDto dto) {
		User usr = userRepository.getUserByEmail(dto.getUserName(), false);
		if (Objects.isNull(usr) || !passwordEncoder.matches(dto.getPassword(), usr.getPassword())) { 
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
		LoginResponseDto obj = new LoginResponseDto();
		obj.setMessage("Login successfully");
		obj.setToken("andfklsdf435r32kfsflk");
		return obj;
	}

}
