package com.project.minibacktesting_be.controller;
import com.project.minibacktesting_be.dto.portfolio.PortfolioSaveResponseDto;
import com.project.minibacktesting_be.security.provider.UserDetailsImpl;
import com.project.minibacktesting_be.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    // 좋아요
    @PostMapping("/portfolios/{portId}/likes")
    public PortfolioSaveResponseDto postLikes(@PathVariable Long portId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likesService.postLikes(portId, userDetails);
    }


    // 좋아요 취소
    @DeleteMapping ("/portfolios/{portId}/likes")
    public PortfolioSaveResponseDto postDislikes(@PathVariable Long portId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likesService.postDislikes(portId, userDetails);
    }
}