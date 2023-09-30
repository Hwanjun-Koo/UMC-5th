package com.example.umc1.domain.member.entity;

import com.example.umc1.domain.member.dto.MemberUpdateRequestDto;
import com.example.umc1.domain.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "BIRTHDAY")
    private String birthday;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    public void updateMember(MemberUpdateRequestDto requestDto) {
        if (requestDto.getName() != null) {
            this.name = requestDto.getName();
        }
        if (requestDto.getNickname() != null) {
            this.nickname = requestDto.getNickname();
        }
        if (requestDto.getPhoneNumber() != null) {
            this.phoneNumber = requestDto.getPhoneNumber();
        }
    }
}
