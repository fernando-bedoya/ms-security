package com.uc.ms_security.service;

import com.uc.ms_security.dto.profile.CreateProfileDTO;
import com.uc.ms_security.dto.profile.ProfileResponseDTO;
import com.uc.ms_security.dto.profile.UpdateProfileDTO;
import com.uc.ms_security.entity.Profile;
import com.uc.ms_security.exception.ApplicationException;
import com.uc.ms_security.exception.ErrorCase;
import com.uc.ms_security.mapper.ProfileMapper;
import com.uc.ms_security.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public ProfileResponseDTO create(CreateProfileDTO dto) {
        Profile profile = profileMapper.toEntity(dto);
        return profileMapper.toResponseDTO(profileRepository.save(profile));
    }

    public List<ProfileResponseDTO> findAll() {
        return profileMapper.toResponseDTOList(profileRepository.findAll());
    }

    public ProfileResponseDTO findById(Long id) {
        return profileMapper.toResponseDTO(findProfile(id));
    }

    public ProfileResponseDTO update(Long id, UpdateProfileDTO dto) {
        Profile profile = findProfile(id);
        profileMapper.updateEntity(dto, profile);
        return profileMapper.toResponseDTO(profileRepository.save(profile));
    }

    public void delete(Long id) {
        profileRepository.delete(findProfile(id));
    }

    private Profile findProfile(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(
                        ErrorCase.NOT_FOUND,
                        "Perfil no encontrado con id: " + id
                ));
    }
}