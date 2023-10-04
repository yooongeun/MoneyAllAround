package com.sturdy.moneyallaround.domain.member.controller;

import com.sturdy.moneyallaround.common.ApiResponse;
import com.sturdy.moneyallaround.domain.member.dto.request.CheckNicknameRequest;
import com.sturdy.moneyallaround.domain.member.dto.request.CheckTelnumberRequest;
import com.sturdy.moneyallaround.domain.member.dto.request.FirebaseAuthRequest;
import com.sturdy.moneyallaround.domain.member.dto.request.SignUpRequest;
import com.sturdy.moneyallaround.domain.member.dto.response.FirebaseAuthResponse;
import com.sturdy.moneyallaround.domain.member.service.MemberService;
import com.sturdy.moneyallaround.domain.member.service.RefreshTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Member API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;
    private final RefreshTokenService refreshTokenService;

    @Operation(summary = "닉네임 중복 확인", description = "닉네임 중복을 확인한다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 실패"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "사용자 없음"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 오류")
    })

    @PostMapping("/check/nickname")
    public ApiResponse checkNickname(@RequestBody CheckNicknameRequest request){
        log.info("닉네임 중복 체크");
        return ApiResponse.success(memberService.checkNickname(request));
    }

    @Operation(summary = "전화번호 중복 확인", description = "전화번호 중복을 확인한다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 실패"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "사용자 없음"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 오류")
    })

    @PostMapping("/check/tel")
    public ApiResponse checkTel(@RequestBody CheckTelnumberRequest request){
        log.info("전화번호 중복 체크");
        return ApiResponse.success(memberService.checkTel(request));
    }

    @PostMapping("/firebase")
    public FirebaseAuthResponse firebaseToken(@RequestBody FirebaseAuthRequest firebaseAuthRequest) {
        log.info("파이어베이스 체크");
        return memberService.signIn(firebaseAuthRequest);
    }

    // 회원가입

    // 로그인

    // 로그아웃

    // 회원탈퇴

    // 회원 정보 수정

//    @Operation(summary = "회원가입", description = "전화번호 인증을 통해 회원가입 한다.")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 실패"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "사용자 없음"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 오류")
//    })
//

//    @PostMapping("/signup")
//    public ApiResponse signUp(@RequestBody SignUpRequest request) {
//        log.info("회원가입 시작");
//        return ApiResponse.success(memberService.registNewMember(request));
//    }


//    @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정한다.")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 실패"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "사용자 없음"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 오류")
//    })
//    @PutMapping("/update")
//    public ApiResponse updateMember (@RequestBody UpdateProfileRequest request){
//        Long memberId =
//        return ApiResponse.success(memberService.updateProfile(request, memberId));
//    }


//    @Operation(summary = "로그아웃", description = "로그아웃")
//    @ApiResponses({
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "인증 실패"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "사용자 없음"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 오류")
//    })
//    @PostMapping("/logout")
//    public ApiResponse logout (@RequestBody LogoutRequest reqeust){
//        log.info("로그아웃 시작");
//        log.info("refreshToken={}", reqeust.refreshToken());
//        refreshTokenService.delValues(reqeust.refreshToken()); // Redis에 저장된 refreshToken 삭제
//        return ApiResponse.success("SUCCESS");
//    }




}









